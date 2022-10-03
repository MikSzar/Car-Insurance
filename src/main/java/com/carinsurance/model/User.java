package com.carinsurance.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	@Getter
	@Setter
	private Integer id;
	
	@Getter
	@Setter
	private String firstName, lastName, username, password, confirmPassword, email;

	public User() {}
	
	public User(String firstName, String lastName, String username, String password, String confirmPassword, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", email=" + email + "]";
	}

}
