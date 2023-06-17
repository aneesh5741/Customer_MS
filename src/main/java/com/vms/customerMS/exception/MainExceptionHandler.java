package com.vms.customerMS.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vms.customerMS.util.UserUtility;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class MainExceptionHandler {
	private UserUtility userUtility;
	
	MainExceptionHandler(UserUtility userUtility){
		this.userUtility = userUtility;
	}

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
	
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	//@ResponseStatus(code = HttpStatus.BAD_REQUEST, value = HttpStatus.BAD_REQUEST)
	private ResponseEntity<Map<String,String>> constraintException(ConstraintViolationException ex) {
		ex.getConstraintViolations().stream().forEach((v) -> System.out.println(v.getPropertyPath() +" = "+  v.getMessage()));
		
		
		List<String>ans =  ex.getConstraintViolations().stream().map(v -> {
			return v.getPropertyPath() +"=" + v.getMessage();
		}).collect(Collectors.toList());
		
		String message = String.join(",",ans);
		
		
		Map<String,String> map = userUtility.customResponse(message, HttpStatus.BAD_REQUEST, true);
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.BAD_REQUEST);
	}

}
