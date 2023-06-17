package com.vms.customerMS.entity;

import com.vms.customerMS.util.Constant;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Entity(name = "users")
@Table( name = Constant.USER_TABLE)
public class User {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, orphanRemoval = true)
	@JoinColumn(name = "user_location_id", unique = true)
	private Location userLocation;
	
	//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	//private List<Location> location = new ArrayList<>();
	
	@NotNull(message = "phone number cannot be blank")
	@Column(name = "phone_number")
	private Long phoneNumber;
	
	@Email
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Role role;
	
	@Column(name = "created")
	private String createdBy;
	
//	@JsonFormat(pattern = "dd.MM.yyyy")
//	@Column(name = "createdAt", insertable = false, updatable = false)
//	private Timestamp createdAt;
	
	@Column(name = "changed")
	private String changedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public Location getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(Location userLocation) {
		this.userLocation = userLocation;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
	
//	@JsonFormat(pattern = "dd.MM.yyyy")
//	@Column(name = "changedAt")
//	private Timestamp changedAt;
	
	
//	@PrePersist
//	private void createUUid() {
//		this.setUuId(UUID.randomUUID().toString());
//	}
	
}
