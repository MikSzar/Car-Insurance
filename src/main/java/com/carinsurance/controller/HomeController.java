package com.carinsurance.controller;

import java.util.List;

import com.carinsurance.model.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.carinsurance.exception.CarNotFoundException;
import com.carinsurance.service.ICarService;

@Controller
public class HomeController {

	@Autowired
	ICarService carService;


	@GetMapping("/")
	public String goToHome(ModelMap model) {
		populateModelCarInsurance(model);
		return "home";
	}

	@PostMapping("/")
	public String createNewInsurance(ModelMap model, @ModelAttribute Insurance insurance) {
		carService.createCarInsurance(insurance);
		populateModelCarInsurance(model);
		return "home";
	}


	@GetMapping("details/{id}")
	public String goToDetails(ModelMap model, @PathVariable Integer id) {
		Insurance insurance = carService.findInsuranceById(id);
		if(insurance.isInsurancePeriodNotExceeded()){
			if(insurance.isValueOfDamageBiggerThanSeventyPercentOfCarValue()){
				model.addAttribute("totalDamage", insurance.totalDamage());
				model.addAttribute("insurance", insurance);
				return "biggerDamage";
			}else {
				model.addAttribute("insurance", insurance);
				return "details";
			}
		}else {
			model.addAttribute("insurance", insurance);
			return "periodExceeded";
		}
	}

	@PostMapping("/filtered/name")
	public String filterByName(ModelMap model, @RequestParam String name) {
		populateModelCarInsurance(model);
		List<Insurance> filteredList;
		filteredList = carService.filterByCarName(name);
		model.addAttribute("filteredInsurance", filteredList);
		return "home";
	}

	@PostMapping("/filtered/registrationNumber")
	public String filterByRegistrationNumber(ModelMap model, @RequestParam String registrationNumber) {
		populateModelCarInsurance(model);
		List<Insurance> filteredList;
		filteredList = carService.findByRegistrationNumber(registrationNumber);
		model.addAttribute("filteredInsurance", filteredList);
		return "home";
	}

	@ExceptionHandler(CarNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ModelAndView carInsuranceNotFound(CarNotFoundException ex) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", ex.getMessage());
		modelAndView.setViewName("CarNotFound");
		return modelAndView;
	}

	private void populateModelCarInsurance(ModelMap model) {
		model.addAttribute("insurance", carService.findAllCarInsurance());
	}
}
