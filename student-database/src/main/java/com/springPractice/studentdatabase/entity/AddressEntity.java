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
	
	@Column(name = "address_lane_1")
	private String addressLane1;
	
	@Column(name = "address_lane_2")
	private String addressLane2;
	
	private String landmark;
	private String city;
	private String state;
	private String country;
	
	@Column(name = "postal_code")
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
	
	public static AddressDTO getDtoObject(AddressEntity addressEntity) {
		AddressDTO address = new AddressDTO(
				addressEntity.getAddressId(), addressEntity.getAddressLane1(), addressEntity.getAddressLane2(), 
				addressEntity.getLandmark(), addressEntity.getCity(), addressEntity.getState(), 
				addressEntity.getCountry(), addressEntity.getPostalCode());
		return address;
	}
}
