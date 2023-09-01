package com.murli.service;

import java.util.List;

import com.murli.entity.Vehicle;
import com.murli.exception.VehicalException;

public interface VehicleService {
	public List<Vehicle> getAllVehicle() throws VehicalException;

	public Vehicle getVehicle(Integer id) throws VehicalException;

	public Vehicle saveVehicle(Vehicle vehicle) throws VehicalException;

	public Vehicle updateVehicle(Integer id, Vehicle vehicle) throws VehicalException;

	public Vehicle deleteVehicle(Integer id) throws VehicalException;
}
