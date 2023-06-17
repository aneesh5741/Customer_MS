package com.vms.customerMS.dao;

import org.springframework.stereotype.Component;

import com.vms.customerMS.dto.UserDTO;
import com.vms.customerMS.entity.User;
import com.vms.customerMS.repository.UserRepository;
import com.vms.customerMS.util.Convertors;

@Component
public class CustomerDaoImpl implements CustomerDao{
	
	private UserRepository userRepository;
	
	private Convertors convertors;
	
	CustomerDaoImpl(UserRepository userRepository, Convertors convertors){
		this.userRepository = userRepository;
		this.convertors = convertors;
	}
	
	public Long createUser(UserDTO userDTO) {
		User user = convertors.UserDTOtoUser(userDTO);
		userRepository.save(user);
		return user.getId();	
	}
	
	
	public UserDTO getUserbyEmail(String emailId) {
		User user =  userRepository.findByemail(emailId);
		UserDTO userDTO = convertors.UserconvertEntityToDTO(user);
		System.out.println(user.getFirstName());
		return userDTO;
	}
	
}
