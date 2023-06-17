package com.vms.customerMS.entity;


import org.hibernate.annotations.NaturalId;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vms.customerMS.util.Constant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Entity
//@Table(schema = Constant.CUSTOMER_SCHEMA, name = Constant.LOCATION_TABLE)
@Entity(name = "location")
@Table(name = "end_user_location")
public class Location {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private String id;
	
	@NaturalId
	@Column(name = "location_id")
	private String locationId;
	
	@Column(name = "street")
	@NotBlank(message = "street empty q h")
	private String street;
	
	@Column(name = "pincode")
	@NotBlank(message = "pincode empty q h")
	private String pincode;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	@NotBlank(message = "city empty q h")
	private String city;
	
	@Column(name = "created")
	private String createdBy;
	
	//@Column(name = "createdAt")
	//private java.util.Date createdAt;
	
	@Column(name = "changed")
	private String changedBy;
	
	//@Column(name = "changedAt")
	//private java.util.Date changedAt;

	public String getUuId() {
		return id;
	}

	public void setUuId(String uuId) {
		this.id = uuId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}
	
	
	@PrePersist
	private void createUUid() {
		this.setUuId(UUID.randomUUID().toString());
	}
}
