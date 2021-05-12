package com.springPractice.studentdatabase.service;

import java.util.List;
import java.util.UUID;

import com.springPractice.studentdatabase.dto.StudentDTO;

public interface StudentService {
	
	// method to add a student into db
	public StudentDTO addStudent(StudentDTO student);
	
	public List<StudentDTO> listAllStudents();
	
	public void removeStudent(StudentDTO student);
	
	public void removeAllStudents();
	
	public StudentDTO getStudentById(UUID id);
	
	public void updateStudentContactNo(UUID id, Long phoneNumber);
}
