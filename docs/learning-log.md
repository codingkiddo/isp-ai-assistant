# Learning log

Record what was built, why it matters, and how it was verified. Mark planned work complete only after the code and verification are present.

## Milestone 1 — Application status

- Built `GET /api/status` using `@RestController` and `@GetMapping`.
- Learned how Spring MVC turns a Java map into JSON.
- Manually verified HTTP 200 and the application/status fields with curl.

## Milestone 2 — Simulated Wi-Fi observation

- Added the `WifiObservation` record and `GET /api/wifi/sample`.
- Made the sample origin explicit with `simulated: true`.
- Manually verified HTTP 200 and the expected JSON response with curl.
- Kept observations separate from conclusions: the response contains no diagnosis.

## Next milestone — Deterministic analysis

Planned: implement a Java analyzer, document demo thresholds, and explain why findings do not establish a definitive root cause.

## Template for future entries

### Milestone — Title

- Goal:
- Implementation:
- Concepts learned:
- Verification and observed result:
- Limitations:
- Next step:
