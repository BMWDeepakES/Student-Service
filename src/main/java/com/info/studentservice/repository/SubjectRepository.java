package com.info.studentservice.repository;

import com.info.studentservice.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository communicate with database.
 * */

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
