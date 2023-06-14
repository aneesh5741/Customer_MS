package com.vms.customerMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.customerMS.dao.CustomerDao;
import com.vms.customerMS.dto.UserDTO;
import com.vms.customerMS.exception.CustomerException;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	public String createSave(UserDTO userDTO) throws CustomerException {
		
		//customer Validators required?
		//if(user.isValid) {
		//custom validation to be done later	
		//}
		
		String isCreated = "";
		try {
		isCreated = customerDao.createUser(userDTO);
		}catch(Exception ex) {
		throw new CustomerException("exception occured");
		}//return isCreated;	
		return isCreated;
	}

}
