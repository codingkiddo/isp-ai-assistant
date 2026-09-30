# API reference

Default local base URL: `http://localhost:8080`.

## GET /api/status

Returns HTTP 200 and JSON:

```json
{"application":"isp-ai-assistant","status":"UP"}
```

JSON object field order is not significant. This static response confirms that the endpoint responds, not that external dependencies are healthy.

## GET /api/wifi/sample

Returns HTTP 200 and a fixed sample:

```json
{
  "homeId": "HOME-1001",
  "deviceId": "DEVICE-TV-001",
  "deviceType": "SMART_TV",
  "accessPointId": "AP-LIVING-ROOM",
  "rssiDbm": -78,
  "snrDb": 15,
  "retryPercentage": 28.0,
  "channelUtilizationPercentage": 85.0,
  "simulated": true
}
```

| Field | Meaning / unit |
| --- | --- |
| `homeId` | Demonstration household identifier |
| `deviceId` | Demonstration device identifier |
| `deviceType` | Sample device category |
| `accessPointId` | Sample associated access point |
| `rssiDbm` | Received signal strength, dBm |
| `snrDb` | Signal-to-noise ratio, dB |
| `retryPercentage` | Simulated retry percentage, 0–100 |
| `channelUtilizationPercentage` | Simulated channel utilization percentage, 0–100 |
| `simulated` | Explicitly identifies synthetic data |

These values are not measured. Measurement windows, retry-counting semantics, timestamps, input validation, authentication, and dynamic device lookup are not implemented. No analysis endpoint exists yet.
