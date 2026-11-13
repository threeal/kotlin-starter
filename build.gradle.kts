plugins {
    alias(libs.plugins.buildconfig)
    alias(libs.plugins.detekt)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kover)
    alias(libs.plugins.ktfmt)
    alias(libs.plugins.maven.publish)
    application
}

group = "io.github.leonardo"

version = "0.1.0"

description = "An example library and CLI for generating a Fibonacci sequence"

repositories { mavenCentral() }

dependencies {
    implementation(libs.clikt.core)
    testImplementation(libs.kotlin.test)
}

dependencyLocking { lockAllConfigurations() }

application { mainClass = "io.github.leonardo.bonacci.MainKt" }

buildConfig {
    packageName("io.github.leonardo.bonacci")
    buildConfigField("VERSION", version.toString())
}

detekt {
    buildUponDefaultConfig = true
    config.setFrom("detekt.yaml")
}

kotlin { compilerOptions { allWarningsAsErrors = true } }

kover {
    reports {
        filters {
            excludes {
                classes("io.github.leonardo.bonacci.Bonacci", "io.github.leonardo.bonacci.MainKt")
            }
        }
        verify { rule { minBound(100) } }
    }
}

ktfmt { kotlinLangStyle() }

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()

    pom {
        name = "Bonacci"
        description = project.description
        url = "https://github.com/leonardo/bonacci"
        licenses {
            license {
                name = "The Unlicense"
                url = "https://unlicense.org/"
            }
        }
        developers {
            developer {
                id = "leonardo"
                name = "Leonardo Bonacci"
                url = "https://github.com/leonardo"
            }
        }
        scm {
            url = "https://github.com/leonardo/bonacci"
            connection = "scm:git:https://github.com/leonardo/bonacci.git"
            developerConnection = "scm:git:ssh://git@github.com/leonardo/bonacci.git"
        }
    }
}

tasks.test { useJUnitPlatform() }
