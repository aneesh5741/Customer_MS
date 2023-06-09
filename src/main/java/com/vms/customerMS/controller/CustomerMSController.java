package com.vms.customerMS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerMSController {
	
	//fetchUserProfile(need PathVariable): fetchUserProfile >> user/fetch/{email} >> return User object
	@GetMapping(path = "/user/fetch/{email}")
	public Object fetchUserProfile(@PathVariable(value = "emailId") String emailId) {
		return "hello3453";
	}

	//SaveUser(): fetchUserProfile >> user/save >> return User object -- @RequestBody
	@PutMapping(path = "/user/save")
	public Object saveUser() {
		return "hello3453";
	}
	
	//DeleteUser(need PathVariable): deleteUserProfile >> user/delete/{email}  -> return deleteCount
	@DeleteMapping(path = "/user/delete/{emailId}")
	public Integer deleteUser(@PathVariable(value = "emailId") String emailId) {
		return 1;
	}

	//UpdateUser(need PathVariable): user/update/ -> RequestBody -> return UserObject
	@PutMapping(path = "/user/update/{emailId}")
	public Object UpdateUser(@PathVariable(value = "emailId") String emailId) {
		return new Object();
	}

	//fetchOrders(need PathVaribale): user/get/orders/{email} -> return list of orders.(Static orders)
	@GetMapping(path = "/user/get/orders/{email}")
	public List<Object> fetchOrders(@PathVariable(value = "emailId") String emailId) {
		return new ArrayList<>();
	}

}
