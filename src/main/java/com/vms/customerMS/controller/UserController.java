package com.vms.customerMS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vms.customerMS.entity.User;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	//fetchUserProfile(need PathVariable): fetchUserProfile >> user/fetch/{email} >> return User object
	@GetMapping(path = "/fetch/{email}")
	public User fetchUserProfile(@PathVariable String email) {
		return null;
	}

	//SaveUser(): fetchUserProfile >> user/save >> return User object -- @RequestBody
	@PostMapping(path = "/save")
	public User saveUser(@RequestBody User user) {
		return null;
	}
	
	//DeleteUser(need PathVariable): deleteUserProfile >> user/delete/{email}  -> return deleteCount
	@DeleteMapping(path = "/delete/{email}")
	public Integer deleteUser(@PathVariable String email) {
		return 1;
	}

	//UpdateUser(need PathVariable): user/update/ -> RequestBody -> return UserObject
	@PutMapping(path = "/update")
	public User updateUser(@RequestBody User user) {
		return null;
	}

	//fetchOrders(need PathVaribale): user/get/orders/{email} -> return list of orders.(Static orders)
	@GetMapping(path = "/fetch/orders/{email}")
	public List<Object> fetchOrders(@PathVariable String email) {
		return new ArrayList<>();
	}

}
