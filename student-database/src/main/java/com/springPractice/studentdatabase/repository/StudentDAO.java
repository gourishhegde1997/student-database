package com.springPractice.studentdatabase.repository;

import com.springPractice.studentdatabase.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface StudentDAO extends JpaRepository<StudentEntity, UUID> {
    List<StudentEntity> findByStudentName(String studentName);

    List<StudentEntity> findByContactNumber(String contactNumber);

    @Query(value = "select s from StudentEntity s where s.email = ?1 and s.studentName = ?2", nativeQuery = false)
    List<StudentEntity> findByEmailAndName(String email, String name);
}
