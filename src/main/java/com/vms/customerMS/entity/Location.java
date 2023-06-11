package com.vms.customerMS.entity;

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
@Entity
@Table(schema = Constant.CUSTOMER_SCHEMA, name = Constant.LOCATION_TABLE)
public class Location {

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
