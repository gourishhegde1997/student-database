package com.springPractice.studentdatabase.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springPractice.studentdatabase.entity.StudentEntity;

public interface StudentDAO extends JpaRepository<StudentEntity, UUID>{
}
