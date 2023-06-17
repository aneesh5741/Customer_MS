package com.vms.customerMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.customerMS.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	User findByemail(String emailId);

}
