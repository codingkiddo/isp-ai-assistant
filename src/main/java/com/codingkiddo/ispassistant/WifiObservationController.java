package com.codingkiddo.ispassistant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WifiObservationController {

	private final WifiAnalyzer analyzer;

    public WifiObservationController(WifiAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    @GetMapping("/api/wifi/sample")
    public WifiObservation sample() {
        return new WifiObservation(
                "HOME-1001",
                "DEVICE-TV-001",
                "SMART_TV",
                "AP-LIVING-ROOM",
                -55,
                35,
                2.0,
                25.0,
                true
        );
    }

    @GetMapping("/api/wifi/sample/analysis")
    public WifiAnalysis analyzeSample() {
        return analyzer.analyze(sample());
    }

}