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

import com.murli.entity.GPSData;
import com.murli.exception.GPSDataException;
import com.murli.service.GPSDataServiceImpl;

@RestController
@RequestMapping("/gps")
public class GPSDataController {

	@Autowired
	private GPSDataServiceImpl gs;

	@GetMapping
	public ResponseEntity<List<GPSData>> getAllGPSData() throws GPSDataException {
		return new ResponseEntity<>(gs.getAllGPSData(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<GPSData> getGPSDataById(@PathVariable Integer id) throws GPSDataException {
		return new ResponseEntity<>(gs.getGPSData(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<GPSData> createGPSData(@RequestBody GPSData gpsData) throws GPSDataException {
		return new ResponseEntity<>(gs.saveGPSData(gpsData), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<GPSData> updateGPSData(@PathVariable Integer id, @RequestBody GPSData updatedGPSData) throws GPSDataException {
		return new ResponseEntity<>(gs.updateGPSData(id, updatedGPSData), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<GPSData> deleteGPSData(@PathVariable Integer id) throws GPSDataException {
		return new ResponseEntity<>(gs.deleteGPSData(id), HttpStatus.OK);
	}
}
