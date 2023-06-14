package com.vms.customerMS.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MainExceptionHandler {

	@ExceptionHandler(value = CustomerException.class)
	// @ResponseStatus(reason = "unexpected Exception occured")
	private ResponseEntity<String> CustomrException(CustomerException ex) {

		// System.out.println("came here");

		Map<String, List<String>> map = new HashMap<>();
		List<String> messages = new ArrayList<>();
		messages.add(ex.getMessage());
		map.put("message", messages);
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
