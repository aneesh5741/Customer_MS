package com.vms.customerMS.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vms.customerMS.dto.LocationDTO;
import com.vms.customerMS.dto.UserDTO;
import com.vms.customerMS.entity.Location;
import com.vms.customerMS.entity.User;


@Mapper(componentModel = "spring")
public interface Convertors {

	@Mapping(target="location", source = "user.userLocation")
	UserDTO UserconvertEntityToDTO(User user);
	LocationDTO locationToLocationDTO(Location location);
	
	@Mapping(target = "userLocation", source = "userDTO.location")
	User UserDTOtoUser(UserDTO userDTO);
	Location LocationDTOToLocation(LocationDTO locationDTO);
}
