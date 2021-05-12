package com.springPractice.studentdatabase.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.springPractice.studentdatabase.dto.StudentDTO;

@Entity
@Table(name = "student", schema = "student_db")
public class StudentEntity {
	
	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID studentId;
	
	@Column(name = "student_name")
	private String studentName;
	
	@Temporal(value = TemporalType.DATE)
	private Date dob;
	
	@Column(name = "contact_no")
	private Long contactNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", unique = true)
	private AddressEntity address;

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

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	
	public static StudentDTO getDtoObject(StudentEntity studentEntity) {
		StudentDTO student = new StudentDTO();
		student.setStudentId(studentEntity.getStudentId());
		student.setStudentName(studentEntity.getStudentName());
		student.setDob(studentEntity.getDob());
		student.setContactNumber(studentEntity.getContactNumber());
		student.setAddress(AddressEntity.getDtoObject(studentEntity.getAddress()));
		return student;
	}
	
	public StudentEntity() {}

	public StudentEntity(UUID studentId, String studentName, Date dob, Long contactNumber, AddressEntity address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.dob = dob;
		this.contactNumber = contactNumber;
		this.address = address;
	}
	
}
