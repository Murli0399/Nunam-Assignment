package com.murli.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.murli.entity.GPSData;
import com.murli.entity.Vehicle;
import com.murli.exception.VehicalException;
import com.murli.service.GPSDataServiceImpl;
import com.murli.service.VehicleServiceImpl;

@RestController
@RequestMapping("/distance")
public class DistanceController {

	@Autowired
	private GPSDataServiceImpl gs;

	@Autowired
	VehicleServiceImpl vs;

	@GetMapping
	public double calculateDistance(Integer id,
			@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate)
			throws VehicalException {

		List<Vehicle> vehicleList = vs.getAllVehicleByOwner(id);

		List<Integer> vehicleIDList = vehicleList.stream().map(Vehicle::getId).collect(Collectors.toList());

		List<GPSData> gpsDataList = gs.getGPSDataDateRange(vehicleIDList, startDate, endDate);

		double totalDistance = calculateTotalDistance(gpsDataList);

		return totalDistance;
	}

	private double calculateTotalDistance(List<GPSData> gpsDataList) {
		double totalDistance = 0.0;
		GPSData prevGPSData = null;

		for (GPSData gpsData : gpsDataList) {
			if (prevGPSData != null) {

				double distance = calculateDistanceBetweenCoordinates(prevGPSData.getLatitude(),
						prevGPSData.getLongitude(), gpsData.getLatitude(), gpsData.getLongitude());

				totalDistance += distance;
			}
			prevGPSData = gpsData;
		}

		return totalDistance;
	}

	private double calculateDistanceBetweenCoordinates(double lat1, double lon1, double lat2, double lon2) {
		final int R = 6371;

		double latDistance = Math.toRadians(lat2 - lat1);
		double lonDistance = Math.toRadians(lon2 - lon1);

		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return R * c;
	}
}
