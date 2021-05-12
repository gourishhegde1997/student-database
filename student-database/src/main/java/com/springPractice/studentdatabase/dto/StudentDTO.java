package com.springPractice.studentdatabase.dto;

import java.util.Date;
import java.util.UUID;

import com.springPractice.studentdatabase.entity.StudentEntity;

public class StudentDTO {
	
	private UUID studentId;
	private String studentName;
	private Date dob;
	private Long contactNumber;
	private AddressDTO address;
	
	public UUID getStudentId() {
		return studentId;
	}
	public void setStudentId(UUID studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "StudentDTO [studentId=" + studentId + ", studentName=" + studentName + ", dob=" + dob
				+ ", contactNumber=" + contactNumber + ", address=" + address + "]";
	}
	
	public static StudentEntity getEntityObject(StudentDTO student) {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setStudentId(student.getStudentId());
		studentEntity.setStudentName(student.getStudentName());
		studentEntity.setDob(student.getDob());
		studentEntity.setContactNumber(student.getContactNumber());
		studentEntity.setAddress(AddressDTO.getEntityObject(student.getAddress()));
		return studentEntity;
	}
	
	public StudentDTO(UUID studentId, String studentName, Date dob, Long contactNumber, AddressDTO address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.dob = dob;
		this.contactNumber = contactNumber;
		this.address = address;
	}
	
	public StudentDTO() {}
}
