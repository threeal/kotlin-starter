# Kotlin Starter

A minimal template for building a [Kotlin](https://kotlinlang.org/) library with an optional CLI on the JVM. Ships pre-configured with formatting enforcement, 100% test coverage enforcement, pre-commit hooks, and CI.

This template is at an early stage: the Gradle build, the sample library with its tests, the sample CLI, and coverage enforcement are in place, but Kotlin formatting and linting are yet to come.

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

- **`.github/workflows/ci.yaml`** — Extend or replace the CI workflow.
- **`.github/dependabot.yaml`** — Adjust update frequency or add more package ecosystems.
- **`src/main/kotlin/Fibonacci.kt`** — Replace with your own library logic.
- **`src/main/kotlin/Main.kt`** — Replace or remove the placeholder CLI. Remove this file, the `application` plugin with its block and the CLI's coverage exclusion in `build.gradle.kts`, and the Clikt dependency if your project doesn't need a CLI.
- **`build.gradle.kts`** — Update the group, version, and description, and add the plugins and dependencies your project needs.
- **`CLAUDE.md`** — Replace with guidance specific to your project.
- **`dprint.json`** — Add or remove dprint plugins for your language.
- **`lefthook.yaml`** — Add more pre-commit checks or other Git hooks.
- **`LICENSE`** — Replace with your preferred license, or keep the [Unlicense](https://unlicense.org/).
- **`README.md`** — Replace with a description of your project.
- **`settings.gradle.kts`** — Rename the project.

## Development

Write code in `src/main/kotlin/`. Unit tests live in `src/test/kotlin/`. Build the project and run the tests through the Gradle wrapper:

```sh
./gradlew build
```

The build enforces 100% code coverage. When it fails on coverage, run `./gradlew koverHtmlReport` and open `build/reports/kover/html/index.html` to see which lines are uncovered.

Each `git commit` runs the pre-commit hook registered during setup, which checks your changes and fixes what it can in place. If it fails, fix any reported issues, re-stage the changed files, and commit again.

After committing, push to `main` or open a pull request from another branch — CI will run the same checks across all files, plus a full Gradle build.
