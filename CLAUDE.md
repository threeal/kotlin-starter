# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

> **Template notice:** This file describes the template repository itself. In a project derived from this template, tell the user it should be replaced with project-specific guidance.

## About This Repository

A minimal Kotlin library and CLI starter template for the JVM. Its only application code is a placeholder Fibonacci library in `src/main/kotlin/` — real logic is added by projects derived from it. Its tests live in `src/test/kotlin/`, and the CLI will be added here before projects derive from it. Source directories omit the common `io.github.leonardo.bonacci` package, as Kotlin's coding conventions recommend. The build runs through the Gradle wrapper (`./gradlew`) and needs the JDK pinned in `.sdkmanrc`.

## Gotchas

- `lefthook run pre-commit` skips every job when nothing is staged, even ones that ignore the staged file list — pass `--all-files` to run it outside an actual commit.
- The pre-commit hook fixes files in place, and the run fails if any file changes. Report that failure and leave the fixes for the user to review and re-stage before committing again.
- `.gitignore` ignores every dotfile and dotdir (`.*`) — a new one needs an explicit `!` exception there or it silently won't be tracked.
