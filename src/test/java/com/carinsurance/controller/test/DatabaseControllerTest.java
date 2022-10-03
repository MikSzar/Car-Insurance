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

import com.carinsurance.controller.DatabaseController;
import com.carinsurance.service.ICarService;

@SpringBootTest(classes = { DatabaseController.class })
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class DatabaseControllerTest {

	@MockBean
	private ICarService carService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void test_deleteCarInsurance() throws Exception {
		Insurance insurance = new Insurance("Audi A8", 60000, 9500, "ABC 4321", LocalDate.of(2021, Month.JULY, 4), LocalDate.of(2021, Month.APRIL, 1));
		insurance.setId(10);
		mockMvc.perform(post("/deleteCarInsurance").param("id", "10")).andExpect(status().isOk())
				.andExpect(view().name("database"));
		verify(carService, times(1)).deleteCarInsuranceById(insurance.getId());
	}

}
