package com.carinsurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.carinsurance.model.Loguser;
import com.carinsurance.model.User;
import com.carinsurance.service.ICarService;
import com.carinsurance.service.IUserService;

@Controller
public class UserController {

	@Autowired
	IUserService userService;
	
	@Autowired
	ICarService carService;
	
	
	@GetMapping("/registration")
	public String goToUserRegistrationPage(ModelMap model) {
		populateModelCarInsurance(model);
		return "userRegistration";
	}

	@PostMapping("/registration")
	public String registrateNewUser(ModelMap model, @ModelAttribute User user) {
		Loguser loguser = new Loguser();
		if (userService.createUser(user)) {
			loguser.setId(user.getId());
			loguser.setUsername(user.getUsername());
			model.addAttribute("loguser", loguser);
			populateModelCarInsurance(model);
			userService.createUser(user);
			return "database";
		} else {
			return "userNotFound";
		}
	}

	@GetMapping("/login")
	public String goToUserLogin(ModelMap model) {
		populateModelCarInsurance(model);
		return "userLogin";
	}

	@PostMapping("/login")
	public String loginUser(ModelMap model, @RequestParam String username, @RequestParam String password) {
		Loguser loguser = new Loguser();
		if (userService.findByUsernamePassword(username, password) != null) {
			loguser.setId(userService.findByUsernamePassword(username, password).getId());
			loguser.setUsername(username);
			model.addAttribute("loguser", loguser);
			populateModelCarInsurance(model);
			return "database";
		} else {
			return "userNotFound"; 
		}
	}
	
	@GetMapping("/InsuranceDatabase")
	public String goToHomepage(ModelMap model) {
		populateModelCarInsurance(model);
		return "home";
	}
	
	private void populateModelCarInsurance(ModelMap model) {
		model.addAttribute("insurance", carService.findAllCarInsurance());
	}


}
