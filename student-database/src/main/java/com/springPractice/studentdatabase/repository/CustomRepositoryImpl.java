package com.springPractice.studentdatabase.repository;

import com.springPractice.studentdatabase.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomRepositoryImpl implements CustomRepository{

    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public boolean checkStudentExists(String name, String email, String contact) {
        boolean studentExist = false;

        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<StudentEntity> query = builder.createQuery(StudentEntity.class);
        Root<StudentEntity> root = query.from(StudentEntity.class);

        Predicate p1 = builder.equal(root.get("studentName"), name);
        Predicate p2 = builder.equal(root.get("email"), email);
        Predicate p3 = builder.equal(root.get("contactNumber"), contact);
        Predicate finalP = builder.and(p1, (builder.or(p2, p3)));

        query.where(finalP);
        List<StudentEntity> studentEntityList = em.createQuery(query.select(root)).getResultList();
        studentExist = !studentEntityList.isEmpty();
        return studentExist;
    }

    @Override
    public boolean checkStudentExistsWithJPQL(String name, String email, String contact) {
        boolean studentExist = false;
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select s from StudentEntity s where " +
                "s.studentName = :name and s.email = :email or s.contactNumber = :contact");
        query.setParameter("name", name);
        query.setParameter("email", email);
        query.setParameter("contact", contact);
        List<StudentEntity> studentEntityList = query.getResultList();
        if (!studentEntityList.isEmpty()) {
            studentExist = true;
        }
        return studentExist;
    }
}
