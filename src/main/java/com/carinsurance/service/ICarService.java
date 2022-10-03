package com.carinsurance.service;

import java.util.List;

import com.carinsurance.model.Insurance;

public interface ICarService {
	List<Insurance> findAllCarInsurance();

	Insurance findInsuranceById(Integer id);

	void createCarInsurance(Insurance insurance);

	List<Insurance> filterByCarName(String name);
	
	List<Insurance> findByRegistrationNumber(String registrationNumber);

	void deleteCarInsuranceById(int id);
}
