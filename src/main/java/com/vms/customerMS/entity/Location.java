package com.vms.customerMS.entity;


import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NaturalId
	@Column(name = "location_id")
	private String locationId;
	
	@Column(name = "street")
	@NotBlank
	private String street;
	
	@Column(name = "pincode")
	@NotBlank
	private String pincode;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	@NotBlank
	private String city;
	
	@Column(name = "created")
	private String createdBy;
	
	//@Column(name = "createdAt")
	//private java.util.Date createdAt;
	
	@Column(name = "changed")
	private String changedBy;
	
	//@Column(name = "changedAt")
	//private java.util.Date changedAt;

	public Long getUuId() {
		return id;
	}

	public void setUuId(Long uuId) {
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


	@Id
	@Column(name = "id")
	private Long id;
	
	@NotBlank
	@Column(name = "street")
	private String street;
	
	@NotBlank
	@Column(name = "city")
	private String city;
	
	@NotBlank
	@Column(name = "pincode")
	private Long pincode;
	
	@NotBlank
	@Column(name = "state")
	private String state;
	
	@NotNull
	@Column(name = "country")
	@Enumerated(EnumType.STRING)
	private Country country;
	
	@Column(name = "created_by", updatable = false)
	private String createdBy;
	
	@JsonFormat(pattern = "dd.MM.yyyy")
	@Column(name = "created_at", insertable = false, updatable = false)
	private Timestamp createdAt;
	
	@Column(name = "changed_by")
	private String changedBy;
	
	@JsonFormat(pattern = "dd.MM.yyyy")
	@Column(name = "changed_at")
	private Timestamp changedAt;
}
