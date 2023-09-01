package com.murli.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murli.entity.Owner;
import com.murli.exception.OwnerException;
import com.murli.repository.OwnerRepository;

@Service
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerRepository or;

	@Override
	public List<Owner> getAllOwner() throws OwnerException {
		List<Owner> list = or.findAll();
		if (list.isEmpty()) {
			throw new OwnerException("Owner not present");
		}
		return list;
	}

	@Override
	public Owner getOwner(Integer id) throws OwnerException {
		Optional<Owner> v = or.findById(id);

		if (v.isEmpty()) {
			throw new OwnerException("Owner Not Found");
		}
		return v.get();
	}

	@Override
	public Owner saveOwner(Owner owner) throws OwnerException {
		return or.save(owner);
	}

	@Override
	public Owner updateOwner(Integer id, Owner owner) throws OwnerException {
		Optional<Owner> v = or.findById(id);

		if (v.isEmpty()) {
			throw new OwnerException("Owner Not Found");
		}
		Owner o = v.get();

		o.setAddress(owner.getAddress());
		o.setEmail(owner.getEmail());
		o.setLicenseNumber(owner.getLicenseNumber());
		o.setName(owner.getName());
		o.setPhoneNumber(owner.getPhoneNumber());

		return or.save(o);
	}

	@Override
	public Owner deleteOwner(Integer id) throws OwnerException {
		Optional<Owner> v = or.findById(id);

		if (v.isEmpty()) {
			throw new OwnerException("Owner Not Found");
		}
		Owner o = v.get();
		or.deleteById(id);
		return o;
	}

}
