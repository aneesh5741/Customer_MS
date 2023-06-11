package com.vms.customerMS.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vms.customerMS.util.Constant;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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
@Table(schema = Constant.CUSTOMER_SCHEMA, name = Constant.USER_TABLE)
public class User {
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@NotBlank
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "location_id", unique = true)
	private Location location;
	
	@NotBlank
	@Column(name = "phone_number")
	private Long phoneNumber;
	
	@Email
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Role role;
	
	@Column(name = "createdBy", updatable = false)
	private String createdBy;
	
	@JsonFormat(pattern = "dd.MM.yyyy")
	@Column(name = "createdAt", insertable = false, updatable = false)
	private Timestamp createdAt;
	
	@Column(name = "changedBy")
	private String changedBy;
	
	@JsonFormat(pattern = "dd.MM.yyyy")
	@Column(name = "changedAt")
	private Timestamp changedAt;
}
