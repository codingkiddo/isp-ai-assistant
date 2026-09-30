# ISP AI Assistant

[![CI](https://github.com/codingkiddo/isp-ai-assistant/actions/workflows/ci.yml/badge.svg)](https://github.com/codingkiddo/isp-ai-assistant/actions/workflows/ci.yml)
![Java](https://img.shields.io/badge/Java-25-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.1.1-green)

An independent, step-by-step portfolio project exploring how telemetry, deterministic analysis, and AI can support connected-home troubleshooting.

**Current milestone:** a Spring Boot REST API serving application status and one simulated Wi-Fi observation. AI inference, diagnosis, RAG, and automated actions are planned; they are not implemented yet.

## The problem we are exploring

> “Why is my living-room TV buffering, and what evidence supports the explanation?”

The project will evolve from observable network measurements to rule-based findings, grounded explanations, and governed actions whose outcomes can be verified. It is not an Airties product or an implementation of Aura, and does not currently integrate vendor APIs.

## Run locally

Requirements: JDK 25 and an available port 8080. The committed Maven Wrapper downloads Maven 3.9.16 on its first run; no separate Maven installation is required.

```bash
git clone https://github.com/codingkiddo/isp-ai-assistant.git
cd isp-ai-assistant
./mvnw spring-boot:run
```

If the wrapper is not executable, run `chmod +x mvnw`. On Windows, use `mvnw.cmd`.

In another terminal:

```bash
curl -i http://localhost:8080/api/status
curl -s http://localhost:8080/api/wifi/sample | python3 -m json.tool
```

Python is only needed for the optional JSON formatting command.

## Available endpoints

| Method | Path | Purpose |
| --- | --- | --- |
| GET | `/api/status` | Static application status response |
| GET | `/api/wifi/sample` | Fixed, simulated smart-TV Wi-Fi observation |

The status endpoint is a basic demonstration endpoint, not a dependency-readiness check. See [the API guide](docs/api.md) for complete responses and units.

## Current structure

```text
src/main/java/com/codingkiddo/ispassistant/
  IspAiAssistantApplication.java
  StatusController.java
  WifiObservation.java
  WifiObservationController.java
src/main/resources/application.properties
src/test/java/com/codingkiddo/ispassistant/
  IspAiAssistantApplicationTests.java
```

`WifiObservation` is a Java record. Spring MVC serializes controller responses into JSON. Sample values are hardcoded and explicitly marked `simulated: true`; no router or device is queried.

## Learning roadmap

- [x] Create the Spring Boot application and status endpoint.
- [x] Expose a simulated Wi-Fi observation.
- [ ] Add deterministic Wi-Fi analysis with documented demo thresholds.
- [ ] Connect a local model through Spring AI and Ollama.
- [ ] Let the assistant retrieve context through a read-only tool.
- [ ] Retrieve troubleshooting guidance using RAG.
- [ ] Add permissions, action validation, and approval controls.
- [ ] Simulate actions and verify before/after outcomes.
- [ ] Add persistence, event processing, and observability as needed.

Planned design principle: deterministic code computes findings and scores; model-generated explanations must stay within supplied evidence. Missing data should remain explicit. A single Wi-Fi snapshot cannot establish the cause of buffering.

## Build and verification

```bash
./mvnw test
./mvnw clean verify
```

The current automated test checks Spring application-context startup. It does not yet assert endpoint payloads or Wi-Fi analysis behavior. GitHub Actions runs Maven verification on JDK 25 for pushes and pull requests.

## Follow the learning journey

- [Learning log](docs/learning-log.md)
- [API reference](docs/api.md)
- [Contribution guide](CONTRIBUTING.md)

Commit each verified milestone with a focused description. Never commit credentials, private telemetry, or real subscriber identifiers.
