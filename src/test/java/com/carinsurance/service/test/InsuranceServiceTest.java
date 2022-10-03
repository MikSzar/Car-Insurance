package com.carinsurance.service.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.carinsurance.model.Insurance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.carinsurance.repository.CarInsuranceRepository;
import com.carinsurance.service.CarService;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class InsuranceServiceTest {

	@MockBean
	CarInsuranceRepository mockRepo;
	
	@InjectMocks
    CarService carService;

	@Test
	void test_findAllCarInsurance() {
		List<Insurance> expectedList = new ArrayList<>();
		Mockito.when(mockRepo.findAll()).thenReturn(expectedList);
		carService.findAllCarInsurance();
		verify(mockRepo).findAll();
	}
	@Test
	void test_filterByName() {
		List<Insurance> expectedList = new ArrayList<>();
		expectedList.add(new Insurance("Mercedes G", 120000, 1100, "GTT 5555", LocalDate.of(2021, Month.JULY, 10), LocalDate.of(2021, Month.FEBRUARY, 6)));
		String name = "Mercedes G";
		Mockito.when(mockRepo.findByNameContains(name)).thenReturn(expectedList);
		carService.filterByCarName(name);
		verify(mockRepo).findByNameContains(name);
	}
	@Test
	void test_filterByRegistrationNumber() {
		List<Insurance> expectedList = new ArrayList<>();
		expectedList.add(new Insurance("VW Golf 3", 10000, 500, "TDI 7653", LocalDate.of(2011, Month.JUNE, 19), LocalDate.of(2010, Month.APRIL, 12)));
		String registrationNumber = "Poland";
		Mockito.when(mockRepo.findByRegistrationNumber(registrationNumber)).thenReturn(expectedList);
		carService.findByRegistrationNumber(registrationNumber);
		verify(mockRepo).findByRegistrationNumber(registrationNumber);
	}
	
}
