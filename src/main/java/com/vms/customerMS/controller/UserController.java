package com.vms.customerMS.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vms.customerMS.dto.UserDTO;
import com.vms.customerMS.entity.User;
import com.vms.customerMS.exception.CustomerException;
import com.vms.customerMS.service.CustomerService;
import com.vms.customerMS.util.UserUtility;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	private CustomerService customerService;
	private UserUtility userUtility;
	
	public UserController(CustomerService customerService, UserUtility userUtility) {
		this.customerService = customerService;
		this.userUtility = userUtility;
	}

	/**
	 * 1. exception scenarios not covered in API.
	 * 2. use some type of builder to build response for every response
	 * @param email
	 * @return
	 */
	@GetMapping(path = "/{email}",
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(code = HttpStatus.OK, reason = "successfully fetched")
	public UserDTO fetchUserProfile(@PathVariable String email) {
		return customerService.getUserByEmail(email);
	}

	/**
	 * Saves a user, 
	 * 1. custom validation missing like, pincode should contain only number, and city should contain only alphbets etc.
	 * 2. exception scenarios not covered in API.
	 * 3. use some type of builder to build response for every response
	 * @param user
	 * @return
	 * @throws CustomerException
	 */
	@PostMapping( consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
					MediaType.TEXT_PLAIN_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED, value = HttpStatus.CREATED)
	public Map<String,String> saveUser(@RequestBody(required = true) UserDTO user) throws CustomerException {
		customerService.createSave(user);
		Map<String,String> response = userUtility.customResponse("created Successfully",  HttpStatus.CREATED,false);
		return response;
	}
	
	//DeleteUser(need PathVariable): deleteUserProfile >> user/delete/{email}  -> return deleteCount
	@DeleteMapping(path = "/{email}")
	public Integer deleteUser(@PathVariable String email) {
		return 1;
	}

	//UpdateUser(need PathVariable): user/update/ -> RequestBody -> return UserObject

	//can we use patch mapping, instead of full request body we can send the updated things
	@PutMapping(path = "/{email}")
	public User updateUser(@RequestBody(required = true) UserDTO user) {
		return null;
	}

	//fetchOrders(need PathVaribale): user/get/orders/{email} -> return list of orders.(Static orders)
	@GetMapping(path = "/fetch/orders/{email}")
	public List<Object> fetchOrders(@PathVariable String email) {
		return new ArrayList<>();
	}
	
	

}
