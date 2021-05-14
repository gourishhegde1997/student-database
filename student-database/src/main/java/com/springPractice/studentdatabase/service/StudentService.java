package com.springPractice.studentdatabase.service;

import java.util.List;
import java.util.UUID;

import com.springPractice.studentdatabase.dto.StudentDTO;
import com.springPractice.studentdatabase.exceptions.StudentServiceException;

public interface StudentService {
	
	// method to add a student into db
	public StudentDTO addStudent(StudentDTO student) throws StudentServiceException;
	
	public List<StudentDTO> listAllStudents();
	
	public void removeStudent(StudentDTO student);
	
	public void removeAllStudents();
	
	public StudentDTO getStudentById(UUID id) throws StudentServiceException;
	
	public void updateStudentContactNo(UUID id, Long phoneNumber);
}
