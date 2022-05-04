package com.info.studentservice.repository;

import com.info.studentservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository communicate with database.
 * */

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findBySid(Long id);

    Student findByName(String studentName);
}
