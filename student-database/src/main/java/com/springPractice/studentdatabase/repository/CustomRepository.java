package com.springPractice.studentdatabase.repository;

import com.springPractice.studentdatabase.dto.StudentDTO;
import com.springPractice.studentdatabase.entity.StudentEntity;

public interface CustomRepository {
    boolean checkStudentExists(String name, String email, String contact);
    boolean checkStudentExistsWithJPQL(String name, String email, String contact);
}
