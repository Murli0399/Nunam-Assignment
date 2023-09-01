package com.murli.service;

import java.util.List;

import com.murli.entity.Owner;
import com.murli.exception.OwnerException;

public interface OwnerService {
	public List<Owner> getAllOwner() throws OwnerException;

	public Owner getOwner(Integer id) throws OwnerException;

	public Owner saveOwner(Owner vehicle) throws OwnerException;

	public Owner updateOwner(Integer id, Owner vehicle) throws OwnerException;

	public Owner deleteOwner(Integer id) throws OwnerException;
}
