package com.codingkiddo.ispassistant;

public record WifiObservation(String homeId, String deviceId, String deviceType, String accessPointId, int rssiDbm,
		int snrDb, double retryPercentage, double channelUtilizationPercentage, boolean simulated) {
}