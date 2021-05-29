package com.springPractice.studentdatabase.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.springPractice.studentdatabase.dto.StudentDTO;
import com.springPractice.studentdatabase.exceptions.StudentServiceException;

public interface StudentService {
	
	// method to add a student into db
	StudentDTO addStudent(StudentDTO student) throws StudentServiceException;
	
	List<StudentDTO> listAllStudents();
	
	void removeStudent(StudentDTO student);
	
	void removeAllStudents();
	
	StudentDTO getStudentById(UUID id) throws StudentServiceException;
	
	void updateStudentContactNo(UUID id, String phoneNumber);

	List<StudentDTO> findAll(Sort sort) throws StudentServiceException;

	List<StudentDTO> findAll(Pageable page) throws StudentServiceException;

	Long getStudentsCount();

	List<StudentDTO> findByStudentName(String studentName);

	List<StudentDTO> findByContactNumber(String contactNumber);

	List<StudentDTO> findByEmailAndName(String email, String studentName);
}
