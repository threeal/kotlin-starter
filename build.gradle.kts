plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "io.github.leonardo"
version = "0.1.0"
description = "An example library and CLI for generating a Fibonacci sequence"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.kotlin.test)
}

tasks.test {
    useJUnitPlatform()
}
