package com.murli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murli.entity.Vehicle;
import com.murli.exception.VehicalException;
import com.murli.service.VehicleServiceImpl;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

	@Autowired
	private VehicleServiceImpl vs;

	@GetMapping
	public ResponseEntity<List<Vehicle>> getAllVehicles() throws VehicalException {
		return new ResponseEntity<>(vs.getAllVehicle(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable Integer id) throws VehicalException {
		return new ResponseEntity<>(vs.getVehicle(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Vehicle>  createVehicle(@RequestBody Vehicle vehicle) throws VehicalException {
		return new ResponseEntity<>(vs.saveVehicle(vehicle),HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable Integer id, @RequestBody Vehicle updatedVehicle) throws VehicalException {
		return new ResponseEntity<>(vs.updateVehicle(id, updatedVehicle),HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Vehicle> deleteVehicle(@PathVariable Integer id) throws VehicalException {
		return new ResponseEntity<>(vs.deleteVehicle(id),HttpStatus.OK);
	}
}
