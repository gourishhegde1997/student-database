package com.springPractice.studentdatabase.dto;

import java.util.UUID;

import com.springPractice.studentdatabase.entity.AddressEntity;

public class AddressDTO {
	
	private UUID addressId;
	private String addressDetails;
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
	
	public AddressDTO(UUID addressId, String addressDetails, Integer postalCode) {
		super();
		this.addressId = addressId;
		this.addressDetails = addressDetails;
		this.postalCode = postalCode;
	}

	public AddressDTO() {
		super();
	}

	@Override
	public String toString() {
		return "AddressDTO [addressId=" + addressId + ", addressDetails=" + addressDetails + ", postalCode="
				+ postalCode + "]";
	}

	public static AddressEntity getEntityObject(AddressDTO address) {
		return new AddressEntity(address.getAddressId(), address.getAddressDetails(), address.getPostalCode());
	}
}
