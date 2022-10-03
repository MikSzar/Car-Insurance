package com.carinsurance.controller;

import java.util.List;

import com.carinsurance.model.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.carinsurance.service.ICarService;

@Controller
public class DatabaseController {

	@Autowired
	ICarService carService;
	
	@GetMapping("/listCarInsurance")
	public String goToCarInsuranceDatabasePage(ModelMap model) {
		populateModelCarInsurance(model);
		return "database";
	}
	
	@PostMapping("/listCarInsurance")
	public String createNewCarInsurance(ModelMap model, @ModelAttribute Insurance insurance) {
		carService.createCarInsurance(insurance);
		populateModelCarInsurance(model);
		return "database";
	}
	
	@PostMapping("/deleteCarInsurance")
	public String deleteInsurance(ModelMap model, @RequestParam int id) {
		carService.deleteCarInsuranceById(id);
		populateModelCarInsurance(model);
		return "database";
	}   
	
	@PostMapping("/listCarInsurance/filtered/name")
	public String filterByName(ModelMap model, @RequestParam String name) {
		populateModelCarInsurance(model);
		List<Insurance> filteredList;
		filteredList = carService.filterByCarName(name);
		model.addAttribute("filteredInsurance", filteredList);
		return "database";
	}
	
	@PostMapping("/listCarInsurance/filtered/registrationNumber")
	public String filterByRegistrationNumber(ModelMap model, @RequestParam String registrationNumber) {
		populateModelCarInsurance(model);
		List<Insurance> filteredList;
		filteredList = carService.findByRegistrationNumber(registrationNumber);
		model.addAttribute("filteredInsurance", filteredList);
		return "database";
	}

	private void populateModelCarInsurance(ModelMap model) {
		model.addAttribute("insurance", carService.findAllCarInsurance());
	}

}
