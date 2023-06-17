package com.vms.customerMS.dao;

import com.vms.customerMS.dto.UserDTO;

public interface CustomerDao {
	public Long createUser(UserDTO userDTO);
	public UserDTO getUserbyEmail(String emailId);
}
