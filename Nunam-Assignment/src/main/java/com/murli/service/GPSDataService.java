package com.murli.service;

import java.util.List;

import com.murli.entity.GPSData;
import com.murli.exception.GPSDataException;

public interface GPSDataService {
	public List<GPSData> getAllGPSData() throws GPSDataException;

	public GPSData getGPSData(Integer id) throws GPSDataException;

	public GPSData saveGPSData(GPSData gpsData) throws GPSDataException;

	public GPSData updateGPSData(Integer id, GPSData gpsData) throws GPSDataException;

	public GPSData deleteGPSData(Integer id) throws GPSDataException;
}
