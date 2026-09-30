package com.codingkiddo.ispassistant;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class WifiAnalyzer {

    public WifiAnalysis analyze(WifiObservation observation) {
        List<String> findings = new ArrayList<>();

        if (observation.rssiDbm() < -70) {
            findings.add("WEAK_SIGNAL");
        }

        if (observation.snrDb() < 20) {
            findings.add("LOW_SNR");
        }

        if (observation.retryPercentage() > 20.0) {
            findings.add("HIGH_RETRIES");
        }

        if (observation.channelUtilizationPercentage() > 80.0) {
            findings.add("BUSY_CHANNEL");
        }

        String summary = findings.isEmpty()
                ? "No issues detected by the demo Wi-Fi rules."
                : "Wi-Fi conditions may contribute to buffering. "
                  + "Additional observations are needed to confirm the cause.";

        return new WifiAnalysis(
                observation,
                List.copyOf(findings),
                summary
        );
    }
}