package com.springPractice.studentdatabase.service;

import com.springPractice.studentdatabase.dto.StudentDTO;
import com.springPractice.studentdatabase.entity.StudentEntity;
import com.springPractice.studentdatabase.exceptions.StudentServiceException;
import com.springPractice.studentdatabase.repository.StudentDAO;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
class StudentServiceImpl implements StudentService {

    private static Logger logger = Logger.getLogger(StudentServiceImpl.class);

    @Autowired
    StudentDAO dao;

    @Override
    public StudentDTO addStudent(StudentDTO student) throws StudentServiceException {
        logger.info("Adding student with data : " + student.toString());
        StudentEntity studentEntity = dao.saveAndFlush(StudentDTO.getEntityObject(student));
        return StudentEntity.getDtoObject(studentEntity);
    }

    @Override
    public List<StudentDTO> listAllStudents() {
        logger.info("Retrieving all students data");
        List<StudentEntity> studentEntityList = dao.findAll();
        List<StudentDTO> studentList = new ArrayList<>();
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
    public StudentDTO getStudentById(UUID id) throws StudentServiceException {
        logger.info("Retrieving Student with student_id : " + id);
        Optional<StudentEntity> optional = dao.findById(id);
        try {
            StudentEntity studentEntity = optional.get();
            StudentDTO student = StudentEntity.getDtoObject(studentEntity);
            logger.info("Student retrieved : " + student.toString());
            return student;
        } catch (NoSuchElementException ex) {
            throw new StudentServiceException("STUDENT_DOES_NOT_EXIST");
        }

    }

    @Override
    public void updateStudentContactNo(UUID id, String phoneNumber) {
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

    @Override
    public List<StudentDTO> findAll(Sort sort) throws StudentServiceException {
        List<StudentDTO> studentsSortedDto = new ArrayList<>();
        Iterable<StudentEntity> studentsSorted = dao.findAll(sort);
        for (StudentEntity studentEntity : studentsSorted) {
            studentsSortedDto.add(StudentEntity.getDtoObject(studentEntity));
        }
        return studentsSortedDto;
    }

    @Override
    public List<StudentDTO> findAll(Pageable page) throws StudentServiceException {
        List<StudentDTO> studentsListDto = new ArrayList<>();
        Page<StudentEntity> studentsPage = dao.findAll(page);
        for (StudentEntity student : studentsPage) {
            studentsListDto.add(StudentEntity.getDtoObject(student));
        }
        return studentsListDto;
    }

    @Override
    public Long getStudentsCount() {
        return dao.count();
    }

    @Override
    public List<StudentDTO> findByStudentName(String studentName) {
        List<StudentDTO> studentsListDto = new ArrayList<>();
        List<StudentEntity> studentsPage = dao.findByStudentName(studentName);
        for (StudentEntity student : studentsPage) {
            studentsListDto.add(StudentEntity.getDtoObject(student));
        }
        return studentsListDto;
    }

    @Override
    public List<StudentDTO> findByContactNumber(String contactNumber) {
        List<StudentDTO> studentsList = new ArrayList<>();
        List<StudentEntity> studentEntityList = dao.findByContactNumber(contactNumber);
        for (StudentEntity student : studentEntityList) {
            studentsList.add(StudentEntity.getDtoObject(student));
        }
        return studentsList;
    }

    @Override
    public List<StudentDTO> findByEmailAndName(String email, String name) {
        List<StudentDTO> studentsList = new ArrayList<>();
        List<StudentEntity> studentEntityList = dao.findByEmailAndName(email, name);
        for (StudentEntity student : studentEntityList) {
            studentsList.add(StudentEntity.getDtoObject(student));
        }
        return studentsList;
    }

    @Override
    public void updateStudentEmail(String email, UUID studentId) {
        dao.updateStudentEmail(email, studentId);
    }

    @Override
    public boolean checkIfStudentExists(String studentName, String email, String contactNum) {
        return dao.checkStudentExists(studentName, email, contactNum);
    }
}
