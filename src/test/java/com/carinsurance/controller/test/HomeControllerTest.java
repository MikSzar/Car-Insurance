package com.carinsurance.controller.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


import com.carinsurance.model.Insurance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.carinsurance.controller.HomeController;
import com.carinsurance.service.ICarService;


@SpringBootTest(classes = {HomeController.class})
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class HomeControllerTest {
	
	@MockBean
	private ICarService carService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void test_goToHome_statusOk() throws Exception {
		List<Insurance> expectedInsuranceList = new ArrayList<>();
		expectedInsuranceList.add(new Insurance("Fiat Uno", 30000, 2000, "ITA 1001", LocalDate.of(2019, Month.DECEMBER, 24), LocalDate.of(2018, Month.MARCH, 8)));
		
		when(carService.findAllCarInsurance()).thenReturn(expectedInsuranceList);
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(model().attribute("insurance", expectedInsuranceList))
				.andExpect(view().name("home"));
	}

	@Test
	void test_filterByName() throws Exception {
		Insurance insurance = new Insurance(11,"BMW X5", 100000, 20000, "NWX 1234", LocalDate.of(2022, Month.JUNE, 12), LocalDate.of(2022, Month.JANUARY, 8));
		mockMvc.perform(post("/filtered/name").param("name", "BMW X5")).andExpect(status().isOk())
				.andExpect(view().name("home"));
		verify(carService, times(1)).filterByCarName(insurance.getName());
	}

	@Test
	void test_filterByRegistrationNumber() throws Exception {
		Insurance insurance = new Insurance(24,"JEEP", 20000, 1500, "XYZ 2244", LocalDate.of(2012, Month.NOVEMBER, 9), LocalDate.of(2007, Month.MARCH, 8));
		mockMvc.perform(post("/filtered/registrationNumber").param("registrationNumber", "XYZ 2244")).andExpect(status().isOk())
				.andExpect(view().name("home"));
		verify(carService, times(1)).findByRegistrationNumber(insurance.getRegistrationNumber());
	}

}
