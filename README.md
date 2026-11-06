# Kotlin Starter

A minimal template for building a [Kotlin](https://kotlinlang.org/) library with an optional CLI on the JVM. Ships pre-configured with formatting enforcement, pre-commit hooks, and CI.

This template is at an early stage: the Gradle build, the sample library and CLI, and their tests are yet to come.

## Getting Started

Create a new repository from this template on GitHub using [this link](https://github.com/new?template_name=kotlin-starter&template_owner=threeal), or clone it locally and point it at your own remote.

## Setup

Install [Lefthook](https://lefthook.dev/) and [dprint](https://dprint.dev/), then register the pre-commit hook:

```sh
lefthook install
```

## Customizing

Replace or extend the template files to fit your project:

- **`.github/workflows/ci.yaml`** — Extend or replace the CI workflow.
- **`.github/dependabot.yaml`** — Adjust update frequency or add more package ecosystems.
- **`CLAUDE.md`** — Replace with guidance specific to your project.
- **`dprint.json`** — Add or remove dprint plugins for your language.
- **`lefthook.yaml`** — Add more pre-commit checks or other Git hooks.
- **`LICENSE`** — Replace with your preferred license, or keep the [Unlicense](https://unlicense.org/).
- **`README.md`** — Replace with a description of your project.

## Development

Each `git commit` runs the pre-commit hook registered during setup, which checks your changes and fixes what it can in place. If it fails, fix any reported issues, re-stage the changed files, and commit again.

After committing, push to `main` or open a pull request from another branch — CI will run the same checks across all files.
