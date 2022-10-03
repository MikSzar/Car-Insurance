package com.carinsurance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CarNotFoundException extends RuntimeException {
	public CarNotFoundException(int id) {
		super("The car issue with id: " + id + " could not be found.");
	}
}
