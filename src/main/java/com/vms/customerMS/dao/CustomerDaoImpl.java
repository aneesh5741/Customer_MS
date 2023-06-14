package com.vms.customerMS.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vms.customerMS.dto.LocationDTO;
import com.vms.customerMS.dto.UserDTO;
import com.vms.customerMS.entity.Location;
import com.vms.customerMS.entity.User;
import com.vms.customerMS.repository.UserRepository;

@Component
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	private UserRepository userRepository;

	
	// can we use some kind of mapper to map values from dto to entity
	public String createUser(UserDTO userDTO) {
		
		// put mapping method in dto and entity respectively
		User user = new User();
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setEmail(userDTO.getEmail());
		user.setRole(userDTO.getRole());

		Location location = new Location();
		LocationDTO locationdto = userDTO.getLocation();
		location.setStreet(locationdto.getStreet());
		location.setPincode(locationdto.getPincode());
		location.setState(locationdto.getState());
		location.setCity(locationdto.getCity());	
		
		user.setUser_location(location);
		userRepository.save(user);
		
		return "created successfully";
		
	}
	
}
