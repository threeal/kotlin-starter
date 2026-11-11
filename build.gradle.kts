plugins {
    alias(libs.plugins.detekt)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kover)
    alias(libs.plugins.ktfmt)
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

application { mainClass = "io.github.leonardo.bonacci.MainKt" }

detekt {
    buildUponDefaultConfig = true
    config.setFrom("detekt.yaml")
}

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

tasks.test { useJUnitPlatform() }
