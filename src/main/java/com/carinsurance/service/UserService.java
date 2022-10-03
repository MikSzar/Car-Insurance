package com.carinsurance.service;

import java.util.List;

import com.carinsurance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carinsurance.model.User;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository repo;

	@Override
	public List<User> findAllUsers() {
		return repo.findAll();
	}

	@Override
	public boolean createUser(User user) {
		List<User> userList = repo.findByUsername(user.getUsername());
		if (userList.isEmpty() && user.getPassword().equals(user.getConfirmPassword())) {
			repo.save(user);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User findByUsernamePassword(String username, String password) {
		User loginUser = null;
		for (int i = 0; i < findAllUsers().size(); i++) {
			if (findAllUsers().get(i).getUsername().equals(username)
					&& findAllUsers().get(i).getPassword().equals(password)) {
				loginUser = findAllUsers().get(i);
			}
		}
		return loginUser;
	}

}
