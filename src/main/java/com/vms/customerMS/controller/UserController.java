package com.vms.customerMS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vms.customerMS.dto.UserDTO;
import com.vms.customerMS.entity.User;
import com.vms.customerMS.exception.CustomerException;
import com.vms.customerMS.service.CustomerService;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	@Autowired
	private CustomerService customerService;
	
	//fetchUserProfile(need PathVariable): fetchUserProfile >> user/fetch/{email} >> return User object
	@GetMapping(path = "/fetch/{email}")
	public User fetchUserProfile(@PathVariable String email) {
		return null;
	}

	//SaveUser(): fetchUserProfile >> user/save >> return User object -- @RequestBody
	@PostMapping(path = "/save")
	@ResponseStatus(value = HttpStatus.CREATED,code = HttpStatus.CREATED,reason = "created successfully")
	//return id of person created.
	public String saveUser(@RequestBody(required = true) UserDTO user) throws CustomerException {
		//customer Validators required?
		return customerService.createSave(user);
	}
	
	//DeleteUser(need PathVariable): deleteUserProfile >> user/delete/{email}  -> return deleteCount
	@DeleteMapping(path = "/delete/{email}")
	public Integer deleteUser(@PathVariable String email) {
		return 1;
	}

	//UpdateUser(need PathVariable): user/update/ -> RequestBody -> return UserObject

	//can we use patch mapping, instead of full request body we can send the updated things
	@PutMapping(path = "/update/{email}")
	public User updateUser(@RequestBody(required = true) UserDTO user) {
		return null;
	}

	//fetchOrders(need PathVaribale): user/get/orders/{email} -> return list of orders.(Static orders)
	@GetMapping(path = "/fetch/orders/{email}")
	public List<Object> fetchOrders(@PathVariable String email) {
		return new ArrayList<>();
	}

}
