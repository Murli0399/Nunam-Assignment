package com.murli.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murli.entity.Vehicle;
import com.murli.exception.VehicalException;
import com.murli.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vr;

	@Override
	public List<Vehicle> getAllVehicle() throws VehicalException {
		List<Vehicle> list = vr.findAll();
		if (list.isEmpty()) {
			throw new VehicalException("Vehicle Not Present");
		}
		return list;
	}

	public List<Vehicle> getAllVehicleByOwner(Integer id) throws VehicalException {
		List<Vehicle> list = vr.findByOwnerId(id);
		if (list.isEmpty()) {
			throw new VehicalException("Vehicle Not Present");
		}
		return list;
	}

	@Override
	public Vehicle getVehicle(Integer id) throws VehicalException {
		Optional<Vehicle> v = vr.findById(id);

		if (v.isEmpty()) {
			throw new VehicalException("Vehicle Not Found");
		}
		return v.get();

	}

	@Override
	public Vehicle saveVehicle(Vehicle vehicle) throws VehicalException {
		return vr.save(vehicle);
	}

	@Override
	public Vehicle updateVehicle(Integer id, Vehicle vehicle) throws VehicalException {
		Optional<Vehicle> v = vr.findById(id);

		if (v.isEmpty()) {
			throw new VehicalException("Vehicle Not Found");
		}
		Vehicle vh = v.get();
		vh.setBikeModel(vehicle.getBikeModel());
		vh.setInsuranceExpiryDate(vehicle.getInsuranceExpiryDate());
		vh.setOwner(vehicle.getOwner());
		vh.setPurchasedDate(vehicle.getPurchasedDate());
		vh.setRegistrationNumber(vehicle.getRegistrationNumber());
		return vr.save(vh);

	}

	@Override
	public Vehicle deleteVehicle(Integer id) throws VehicalException {
		Optional<Vehicle> v = vr.findById(id);

		if (v.isEmpty()) {
			throw new VehicalException("Vehicle Not Found");
		}
		Vehicle vh = v.get();
		vr.deleteById(id);
		return vh;
	}

}
