package com.carinsurance.service;

import java.util.List;

import com.carinsurance.model.User;

public interface IUserService {
	
	List<User> findAllUsers();
	
	boolean createUser(User user);
	
	User findByUsernamePassword(String username, String password);
	

}
