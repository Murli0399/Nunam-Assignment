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

import com.murli.entity.Owner;
import com.murli.exception.OwnerException;
import com.murli.service.OwnerServiceImpl;

@RestController
@RequestMapping("/owners")
public class OwnerController {

	@Autowired
	private OwnerServiceImpl os;

	@GetMapping
	public ResponseEntity<List<Owner>> getAllOwners() throws OwnerException {
		return new ResponseEntity<>(os.getAllOwner(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Owner> getOwnerById(@PathVariable Integer id) throws OwnerException {
		return new ResponseEntity<>(os.getOwner(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) throws OwnerException {
		return new ResponseEntity<>(os.saveOwner(owner), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Owner> updateOwner(@PathVariable Integer id, @RequestBody Owner updatedOwner)
			throws OwnerException {
		return new ResponseEntity<>(os.updateOwner(id, updatedOwner), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Owner> deleteOwner(@PathVariable Integer id) throws OwnerException {
		return new ResponseEntity<>(os.deleteOwner(id), HttpStatus.OK);
	}
}
