package com.vms.customerMS.service;

import org.springframework.stereotype.Service;

import com.vms.customerMS.dao.CustomerDao;
import com.vms.customerMS.dto.UserDTO;
import com.vms.customerMS.exception.CustomerException;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;

	CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	// missing exception handling
	public String createSave(UserDTO userDTO) throws CustomerException {
		Long id = customerDao.createUser(userDTO);
		System.out.println(id);
		return String.valueOf(id);
	}

	// missing exception handling
	public UserDTO getUserByEmail(String emailId) {
		System.out.println(emailId);
		return customerDao.getUserbyEmail(emailId);
	}
}
