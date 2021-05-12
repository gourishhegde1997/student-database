package com.springPractice.studentdatabase.dto;

import java.util.UUID;

import com.springPractice.studentdatabase.entity.AddressEntity;

public class AddressDTO {
	
	private UUID addressId;
	private String addressLane1;
	private String addressLane2;
	private String landmark;
	private String city;
	private String state;
	private String country;
	private Integer postalCode;
	
	
	public UUID getAddressId() {
		return addressId;
	}
	public void setAddressId(UUID addressId) {
		this.addressId = addressId;
	}
	public String getAddressLane1() {
		return addressLane1;
	}
	public void setAddressLane1(String addressLane1) {
		this.addressLane1 = addressLane1;
	}
	public String getAddressLane2() {
		return addressLane2;
	}
	public void setAddressLane2(String addressLane2) {
		this.addressLane2 = addressLane2;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	@Override
	public String toString() {
		return "AddressDTO [addressId=" + addressId + ", addressLane1=" + addressLane1 + ", addressLane2="
				+ addressLane2 + ", landmark=" + landmark + ", city=" + city + ", state=" + state + ", country="
				+ country + ", postalCode=" + postalCode + "]";
	}
	
	public AddressDTO(UUID addressId, String addressLane1, String addressLane2, String landmark, String city,
			String state, String country, Integer postalCode) {
		super();
		this.addressId = addressId;
		this.addressLane1 = addressLane1;
		this.addressLane2 = addressLane2;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
	}
	
	public AddressDTO() {};
	
	public static AddressEntity getEntityObject(AddressDTO address) {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setAddressId(address.getAddressId());
		addressEntity.setAddressLane1(address.getAddressLane1());
		addressEntity.setAddressLane2(address.getAddressLane2());
		addressEntity.setLandmark(address.getLandmark());
		addressEntity.setCity(address.getCity());
		addressEntity.setState(address.getState());
		addressEntity.setCountry(address.getCountry());
		addressEntity.setPostalCode(address.getPostalCode());
		return addressEntity;
	}
	
}
