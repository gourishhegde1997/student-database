package com.springPractice.studentdatabase.entity;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

	private LocalDate dob;

	@Column(name = "contact_no")
	private String contactNumber;

	@Column
	private String email;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String phoneNumber) {
		this.contactNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public static StudentDTO getDtoObject(StudentEntity student) {
		return new StudentDTO(student.getStudentId(), student.getStudentName(), student.getDob(),
				student.getContactNumber(), student.getEmail(), AddressEntity.getDtoObject(student.getAddress()));
	}

	public StudentEntity(UUID studentId, String studentName, LocalDate dob, String contactNumber, String email,
			AddressEntity address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.dob = dob;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
	}

	public StudentEntity() {
		super();
	}

}
