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
import com.carinsurance.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.carinsurance.controller.UserController;
import com.carinsurance.service.ICarService;
import com.carinsurance.service.IUserService;

@SpringBootTest(classes = { UserController.class })
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class UserControllerTest {

	@MockBean
	private ICarService carService;
	
	@MockBean
	private IUserService userService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test_goToUserRegistrationPage_statusOk() throws Exception {
		List<Insurance> expectedInsuranceList = new ArrayList<>();
		expectedInsuranceList.add(new Insurance("Ford mustang GT", 80000, 3500, "WZZ 6666", LocalDate.of(2021, Month.FEBRUARY, 24), LocalDate.of(2020, Month.SEPTEMBER, 5)));
		when(carService.findAllCarInsurance()).thenReturn(expectedInsuranceList);
		
		mockMvc.perform(get("/registration")).andExpect(status().isOk())
				.andExpect(model().attribute("insurance", expectedInsuranceList))
				.andExpect(view().name("userRegistration"));
	}
	
	@Test
	public void test_goToUserLogin_statusOk() throws Exception {
		List<Insurance> expectedInsuranceList = new ArrayList<>();
		expectedInsuranceList.add(new Insurance("Audi TT", 35000, 1500, "NYC 1122", LocalDate.of(2022, Month.JULY, 15), LocalDate.of(2021, Month.OCTOBER, 17)));
		when(carService.findAllCarInsurance()).thenReturn(expectedInsuranceList);

		mockMvc.perform(get("/login")).andExpect(status().isOk())
				.andExpect(model().attribute("insurance", expectedInsuranceList))
				.andExpect(view().name("userLogin"));
	}
	
	@Test
	public void test_goToHomepage_statusOk() throws Exception {
		List<Insurance> expectedInsuranceList = new ArrayList<>();
		expectedInsuranceList.add(new Insurance("Land Rover", 35000, 7500, "VFB 0807", LocalDate.of(2021, Month.MAY, 3), LocalDate.of(2019, Month.OCTOBER, 8)));
		when(carService.findAllCarInsurance()).thenReturn(expectedInsuranceList);
		
		mockMvc.perform(get("/InsuranceDatabase")).andExpect(status().isOk())
				.andExpect(model().attribute("insurance", expectedInsuranceList))
				.andExpect(view().name("home"));
	}
	
}
