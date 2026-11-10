plugins {
    alias(libs.plugins.kotlin.jvm)
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

tasks.test {
    useJUnitPlatform()
}
