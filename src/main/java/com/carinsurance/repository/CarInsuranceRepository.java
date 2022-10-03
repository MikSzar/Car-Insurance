package com.carinsurance.repository;

import java.util.List;

import com.carinsurance.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CarInsuranceRepository extends JpaRepository<Insurance, Integer> {

	List<Insurance> findByNameContains(String name);
	
	@Query("SELECT n FROM Insurance n where n.registrationNumber LIKE %?1%")
	List<Insurance> findByRegistrationNumber(String registrationNumber);

}
