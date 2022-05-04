package com.info.studentservice.service;

import com.info.studentservice.dto.StudentResponse;
import com.info.studentservice.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Service provide interface for Student business logics.
 * */

@Component
public interface StudentService {

    Student saveStudent(Student student);

    Student getStudentBySid(Long id);

    StudentResponse getStudentWithSubject(String studentName);

    List<Student> getAllStudent();

    Student subjectAssignToStudent(Long studentId, Long subjectId);
}
