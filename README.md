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

- **`src/main/kotlin/io/github/leonardo/bonacci/Fibonacci.kt`** — Replace with your own library logic.
- **`src/main/kotlin/io/github/leonardo/bonacci/cli/`** — Replace or remove the placeholder CLI.
- **`build.gradle.kts`** — Update the group, version, description, and the POM metadata under `mavenPublishing`, and add the plugins and dependencies your project needs.
- **`CLAUDE.md`** — Replace with guidance specific to your project.
- **`LICENSE`** — Replace with your preferred license, or keep the [Unlicense](https://unlicense.org/).
- **`README.md`** — Replace with a description of your project.
- **`settings.gradle.kts`** — Rename the project.

If your project doesn't need a CLI, remove:

- `src/main/kotlin/io/github/leonardo/bonacci/cli/`.
- The `application` plugin and its block in `build.gradle.kts`.
- The `buildconfig` plugin and its block in `build.gradle.kts`, along with its entry in `gradle/libs.versions.toml`.
- The `filters` block under `kover` in `build.gradle.kts`, which excludes the CLI from coverage.
- The Clikt dependency in `build.gradle.kts` and its entry in `gradle/libs.versions.toml`.

Then regenerate the lockfile with `./gradlew dependencies --write-locks`.

To rename the package, move the sources under `src/main/kotlin/` and `src/test/kotlin/` to the directories matching it, then replace `io.github.leonardo.bonacci` in:

- The `package` and `import` lines of each source file.
- The `mainClass` in the `application` block of `build.gradle.kts`.
- The `packageName` in the `buildConfig` block of `build.gradle.kts`.
- The package exclusion in the `kover` block of `build.gradle.kts`.

## Development

Write code in `src/main/kotlin/`. Unit tests live in `src/test/kotlin/`. Build the project and run the tests through the Gradle wrapper:

```sh
./gradlew build
```

The build enforces 100% code coverage, excluding packages listed under `filters` in the `kover` block of `build.gradle.kts`.

Each `git commit` runs the pre-commit hook registered during setup, which checks your changes and fixes what it can in place, such as linting Kotlin code with [detekt](https://detekt.dev/) and formatting it with [ktfmt](https://github.com/facebook/ktfmt). If it fails, fix any reported issues, re-stage the changed files, and commit again.

After committing, push to `main` or open a pull request from another branch — CI will run the same checks across all files, plus a full Gradle build.

## Releasing

Update the version in `build.gradle.kts`, push a version tag, and create a GitHub Release. Publishing the library requires a GPG signing key, even for a local publish with `./gradlew publishToMavenLocal`. To publish to [Maven Central](https://central.sonatype.com/), set up a Central Portal account, a namespace, and that key as the [Gradle Maven Publish Plugin](https://vanniktech.github.io/gradle-maven-publish-plugin/central/) describes, add your credentials and key to `~/.gradle/gradle.properties`, then run:

```sh
./gradlew publishAndReleaseToMavenCentral
```
