package com.carinsurance.service;

import java.util.List;
import java.util.Optional;

import com.carinsurance.exception.CarNotFoundException;
import com.carinsurance.model.Insurance;
import com.carinsurance.repository.CarInsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService implements ICarService {

	@Autowired
	private CarInsuranceRepository repo;
	
	@Override
	public List<Insurance> findAllCarInsurance() {
		return repo.findAll();
	}

	@Override
	public Insurance findInsuranceById(Integer id) {
		Optional<Insurance> optInsurance = repo.findById(id);
		if (optInsurance.isPresent())
			return optInsurance.get();
		else
			throw new CarNotFoundException(id);
	}

	@Override
	public void createCarInsurance(Insurance insurance) {
		repo.save(insurance);
	}

	@Override
	public List<Insurance> filterByCarName(String name) {
		return repo.findByNameContains(name);
	}

	@Override
	public void deleteCarInsuranceById(int id) {
		repo.delete(findInsuranceById(id));
	}

	@Override
	public List<Insurance> findByRegistrationNumber(String registrationNumber) {
		return repo.findByRegistrationNumber(registrationNumber);
	}

}
