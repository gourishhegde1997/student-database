package com.springPractice.studentdatabase.repository;

import com.springPractice.studentdatabase.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface StudentDAO extends JpaRepository<StudentEntity, UUID>,CustomRepository {
    List<StudentEntity> findByStudentName(String studentName);

    List<StudentEntity> findByContactNumber(String contactNumber);

    @Query(value = "select s from StudentEntity s where s.email = :email and s.studentName = :name", nativeQuery = false)
    List<StudentEntity> findByEmailAndName(@Param("email") String email, @Param("name") String name);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update StudentEntity s set s.email = :email where s.studentId = :studentId")
    public void updateStudentEmail(@Param("email") String email, @Param("studentId") UUID studentId);
}
