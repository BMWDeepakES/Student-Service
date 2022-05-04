package com.info.studentservice.service;

import com.info.studentservice.entity.Subject;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Service provide interface for Student business logics.
 */

@Component
public interface SubjectService {

    Subject saveSubject(Subject subject);

    Subject getSubjectById(Long id);

    List<Subject> getAllSubjects();
}
