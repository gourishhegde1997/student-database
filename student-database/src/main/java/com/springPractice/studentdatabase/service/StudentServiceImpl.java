package com.springPractice.studentdatabase.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springPractice.studentdatabase.dto.StudentDTO;
import com.springPractice.studentdatabase.entity.StudentEntity;
import com.springPractice.studentdatabase.repository.StudentDAO;

@Service
class StudentServiceImpl implements StudentService {
	
	private static Logger logger = Logger.getLogger(StudentServiceImpl.class);
	
	@Autowired
	StudentDAO dao;

	@Override
	public StudentDTO addStudent(StudentDTO student) {
		logger.info("Adding student with data : " + student.toString());
		StudentEntity studentEntity = dao.saveAndFlush(StudentDTO.getEntityObject(student));
		return StudentEntity.getDtoObject(studentEntity);
	}

	@Override
	public List<StudentDTO> listAllStudents() {
		logger.info("Retrieving all students data");
		List<StudentEntity> studentEntityList = dao.findAll();
		List<StudentDTO> studentList= new ArrayList<>();
		studentEntityList.forEach(s -> studentList.add(StudentEntity.getDtoObject(s)));
		return studentList;
	}

	@Override
	public void removeStudent(StudentDTO student) {
		logger.info("Deleting Student : " + student.toString());
		dao.delete(StudentDTO.getEntityObject(student));
	}

	@Override
	public void removeAllStudents() {
		logger.info("Deleting all the Students");
		dao.deleteAll();
	}

	@Override
	public StudentDTO getStudentById(UUID id) {
		logger.info("Retrieving Student with student_id : "+id);
		Optional<StudentEntity> optional = dao.findById(id);
		StudentEntity studentEntity = optional.get();
		StudentDTO student = StudentEntity.getDtoObject(studentEntity);
		logger.info("Student retrieved : " + student.toString());
		return student;
	}

	@Override
	public void updateStudentContactNo(UUID id, Long phoneNumber) {
		logger.info("Updating Student with id : " + id);
		Optional<StudentEntity> optional = dao.findById(id);
		if (!optional.isEmpty()) {
			StudentEntity studentEntity = optional.get();
			studentEntity.setContactNumber(phoneNumber);
			studentEntity = dao.save(studentEntity);
			logger.info("Student data updated : " + StudentEntity.getDtoObject(studentEntity).toString());
		} else {
			logger.error("Student with id : " + id + " is not present in db");
		}
		
		
	}

}
