package com.springPractice.studentdatabase.controller;

import java.util.List;
import java.util.UUID;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springPractice.studentdatabase.dto.StudentDTO;
import com.springPractice.studentdatabase.exceptions.StudentServiceException;
import com.springPractice.studentdatabase.service.StudentService;

@Controller
@RequestMapping(path = "/studentdb")
public class StudentController {

	public static Logger logger = Logger.getLogger(StudentController.class);
	
	@Autowired
	StudentService service;
	
	@GetMapping(path = "/getstudent") 
	public ResponseEntity<List<StudentDTO>> getAllStudents() {
		List<StudentDTO> studentsList = service.listAllStudents();
		return new ResponseEntity<>(studentsList, HttpStatus.OK);
	}
	
	@GetMapping(path = "/getstudent/{studentId}") 
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable UUID studentId) {
		StudentDTO student;
		try {
			student = service.getStudentById(studentId);
			return new ResponseEntity<StudentDTO>(student, HttpStatus.OK);
		} catch (StudentServiceException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		
	}
}
