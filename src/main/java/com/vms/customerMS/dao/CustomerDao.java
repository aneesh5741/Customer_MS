package com.vms.customerMS.dao;

import com.vms.customerMS.dto.UserDTO;

public interface CustomerDao {
	public String createUser(UserDTO userDTO);
}
