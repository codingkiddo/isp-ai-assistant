package com.codingkiddo.ispassistant;

import java.util.List;

public record WifiAnalysis(
        WifiObservation observation,
        List<String> findings,
        String summary
) {
}