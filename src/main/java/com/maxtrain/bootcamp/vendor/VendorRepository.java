package com.maxtrain.bootcamp.vendor;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface VendorRepository extends CrudRepository<Vendor, Integer> {
	//returning a vendor code that is unique
	//<vendor>findByStatus(String Code); Optional
	Optional<Vendor> findByCode(String code);

}
