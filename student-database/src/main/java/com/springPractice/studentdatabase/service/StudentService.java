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
	public StudentDTO addStudent(StudentDTO student) throws StudentServiceException;
	
	public List<StudentDTO> listAllStudents();
	
	public void removeStudent(StudentDTO student);
	
	public void removeAllStudents();
	
	public StudentDTO getStudentById(UUID id) throws StudentServiceException;
	
	public void updateStudentContactNo(UUID id, String phoneNumber);

	public List<StudentDTO> findAll(Sort sort) throws StudentServiceException;

	public List<StudentDTO> findAll(Pageable page) throws StudentServiceException;

	public Long getStudentsCount();

	public List<StudentDTO> findByStudentName(String studentName);

}
