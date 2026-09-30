package com.codingkiddo.ispassistant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WifiObservationController {

	@GetMapping("/api/wifi/sample")
	public WifiObservation sample() {
		return new WifiObservation("HOME-1001", "DEVICE-TV-001", "SMART_TV", "AP-LIVING-ROOM", -78, 15, 28.0, 85.0,
				true);
	}
}