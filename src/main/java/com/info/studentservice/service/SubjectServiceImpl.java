package com.info.studentservice.service;

import com.info.studentservice.entity.Subject;
import com.info.studentservice.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * this class implements service interface for create subject business logics.
 * */

@Component
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject getSubjectById(Long id) {
        Subject subject=subjectRepository.findById(id).get();
        if(subject==null){
            throw new NullPointerException(" Passed SubjectId "+id+" not available for Subject ");
        }
        return subject;
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
}
