package com.springPractice.studentdatabase.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.springPractice.studentdatabase.entity.StudentEntity;

public class StudentDTO {
	
	private UUID studentId;
	private String studentName;
	private LocalDate dob;
	private String contactNumber;
	private String email;
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
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	
	public StudentDTO(UUID studentId, String studentName, LocalDate dob, String contactNumber, String email,
			AddressDTO address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.dob = dob;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
	}
	
	public StudentDTO() {
		super();
	}
	
	@Override
	public String toString() {
		return "StudentDTO [studentId=" + studentId + ", studentName=" + studentName + ", dob=" + dob
				+ ", contactNumber=" + contactNumber + ", email=" + email + ", address=" + address + "]";
	}
	
	public static StudentEntity getEntityObject(StudentDTO student) {
		return new StudentEntity(student.getStudentId(), student.getStudentName(),
				student.getDob(), student.getContactNumber(),
				student.getEmail(), AddressDTO.getEntityObject(student.getAddress()));
	}
}
