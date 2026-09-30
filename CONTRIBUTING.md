# Contributing

This is a learning project built in small, reviewable milestones. Issues explaining bugs, unclear documentation, or reproducible troubleshooting scenarios are welcome.

## Local workflow

1. Create a focused branch: `git switch -c docs/describe-your-change`.
2. Make the change and keep documentation consistent with implemented behavior.
3. Run `./mvnw clean verify` with JDK 25 for code changes.
4. For documentation changes, check commands, relative links, and endpoint names.
5. Review `git diff` and `git diff --cached` before committing.
6. Open a pull request describing the result and how you verified it.

Use synthetic telemetry. Do not include tokens, credentials, customer data, or proprietary vendor documentation. Identify mocks and simulated adapters explicitly. Add meaningful behavior tests when introducing analysis or execution logic.

Suggested commit examples: `feat: add rule-based Wi-Fi analysis`, `docs: explain sample observation fields`, `fix: correct observation units`.
