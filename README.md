# Kotlin Starter

A minimal template for building a [Kotlin](https://kotlinlang.org/) library with an optional CLI on the JVM. Ships pre-configured with formatting and linting enforcement, 100% test coverage enforcement, pre-commit hooks, and CI.

## Getting Started

Create a new repository from this template on GitHub using [this link](https://github.com/new?template_name=kotlin-starter&template_owner=threeal), or clone it locally and point it at your own remote.

## Setup

Install [SDKMAN!](https://sdkman.io/), then install the JDK pinned in `.sdkmanrc`:

```sh
sdk env install
```

Install [Lefthook](https://lefthook.dev/) and [dprint](https://dprint.dev/), then register the pre-commit hook:

```sh
lefthook install
```

## Customizing

Replace or extend the template files to fit your project:

- **`src/main/kotlin/Fibonacci.kt`** — Replace with your own library logic.
- **`src/main/kotlin/Main.kt`** — Replace or remove the placeholder CLI. Remove this file, the `application` plugin with its block and the CLI's coverage exclusion in `build.gradle.kts`, and the Clikt dependency if your project doesn't need a CLI.
- **`build.gradle.kts`** — Update the group, version, description, and the POM metadata under `mavenPublishing`, and add the plugins and dependencies your project needs.
- **`CLAUDE.md`** — Replace with guidance specific to your project.
- **`detekt.yaml`** — Update the root package to match your package name.
- **`LICENSE`** — Replace with your preferred license, or keep the [Unlicense](https://unlicense.org/).
- **`README.md`** — Replace with a description of your project.
- **`settings.gradle.kts`** — Rename the project.

## Development

Write code in `src/main/kotlin/`. Unit tests live in `src/test/kotlin/`. Build the project and run the tests through the Gradle wrapper:

```sh
./gradlew build
```

The build enforces 100% code coverage. When it fails on coverage, run `./gradlew koverHtmlReport` and open `build/reports/kover/html/index.html` to see which lines are uncovered.

Each `git commit` runs the pre-commit hook registered during setup, which checks your changes and fixes what it can in place, such as linting Kotlin code with [detekt](https://detekt.dev/) and formatting it with [ktfmt](https://github.com/facebook/ktfmt). If it fails, fix any reported issues, re-stage the changed files, and commit again.

After committing, push to `main` or open a pull request from another branch — CI will run the same checks across all files, plus a full Gradle build.

## Releasing

Update the version in `build.gradle.kts` and in the CLI's `versionOption` in `src/main/kotlin/Main.kt`, push a version tag, and create a GitHub Release. Publishing the library requires a GPG signing key, even for a local publish with `./gradlew publishToMavenLocal`. To publish to [Maven Central](https://central.sonatype.com/), set up a Central Portal account, a namespace, and that key as the [Gradle Maven Publish Plugin](https://vanniktech.github.io/gradle-maven-publish-plugin/central/) describes, add your credentials and key to `~/.gradle/gradle.properties`, then run:

```sh
./gradlew publishAndReleaseToMavenCentral
```
