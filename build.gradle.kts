plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kover)
    application
}

group = "io.github.leonardo"
version = "0.1.0"
description = "An example library and CLI for generating a Fibonacci sequence"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.clikt.core)
    testImplementation(libs.kotlin.test)
}

application {
    mainClass = "io.github.leonardo.bonacci.MainKt"
}

kover {
    reports {
        filters {
            excludes {
                classes("io.github.leonardo.bonacci.Bonacci", "io.github.leonardo.bonacci.MainKt")
            }
        }
        verify {
            rule {
                minBound(100)
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
