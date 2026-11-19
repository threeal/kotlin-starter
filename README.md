# Kotlin Starter

A minimal template for building a [Kotlin](https://kotlinlang.org/) library with an optional CLI on the JVM. Ships pre-configured with formatting, linting, 100% test coverage enforcement, pre-commit hooks, and CI.

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

- **`src/`** — Replace the placeholder library, CLI, and tests with your own code.
- **`build.gradle.kts`** — Update the group, version, description, and other metadata.
- **`CLAUDE.md`** — Replace with guidance specific to your project.
- **`LICENSE`** — Replace with your preferred license, or keep the [Unlicense](https://unlicense.org/).
- **`README.md`** — Replace with a description of your project.
- **`settings.gradle.kts`** — Rename the project.

If your project doesn't need a CLI, remove the `cli` package, along with the `application` and `buildconfig` plugins, the Kover exclusion, and the Clikt dependency in `build.gradle.kts`.

## Development

Build the project and run the tests through the Gradle wrapper:

```sh
./gradlew build
```

The build enforces 100% code coverage, excluding packages listed under `filters` in the `kover` block of `build.gradle.kts`. Dependencies are locked in `gradle.lockfile`, so regenerate it with `./gradlew dependencies --write-locks` after changing them.

Each `git commit` runs the pre-commit hook registered during setup, which checks your changes and fixes what it can in place. If it fails, fix any reported issues, re-stage the changed files, and commit again.

After committing, push to `main` or open a pull request from another branch — CI will run the same checks across all files, plus additional checks of its own.

## Releasing

Update the version in `build.gradle.kts`, push a version tag, and create a GitHub Release. To publish to [Maven Central](https://central.sonatype.com/), set up your account and signing key as the [Gradle Maven Publish Plugin](https://vanniktech.github.io/gradle-maven-publish-plugin/central/) describes, then run:

```sh
./gradlew publishAndReleaseToMavenCentral
```
