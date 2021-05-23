package com.springPractice.studentdatabase.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import com.springPractice.studentdatabase.dto.AddressDTO;

@Entity
@Table(name = "address", schema = "student_db")
//@GenericGenerator(name = "id_gen", strategy = "increment")
public class AddressEntity {
	
	@Id
	@Column(name = "address_id")
//	@GeneratedValue(generator = "id_gen")
	@GeneratedValue
	private UUID addressId;
	
	@Column(name = "address_details")
	private String addressDetails;
	
	@Column(name = "postal_code")
	private Integer postalCode;

	public UUID getAddressId() {
		return addressId;
	}

	public void setAddressId(UUID addressId) {
		this.addressId = addressId;
	}

	public String getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(String addressDetails) {
		this.addressDetails = addressDetails;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	
	public static AddressDTO getDtoObject(AddressEntity address) {
		return new AddressDTO(address.getAddressId(), address.getAddressDetails(), address.getPostalCode());
	}

	public AddressEntity(UUID addressId, String addressDetails, Integer postalCode) {
		super();
		this.addressId = addressId;
		this.addressDetails = addressDetails;
		this.postalCode = postalCode;
	}

	public AddressEntity() {
		super();
	}
	
}
