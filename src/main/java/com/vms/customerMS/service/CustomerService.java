package com.vms.customerMS.service;

import com.vms.customerMS.dto.UserDTO;
import com.vms.customerMS.exception.CustomerException;

public interface CustomerService {
	public String createSave(UserDTO userDTO) throws CustomerException;

}
