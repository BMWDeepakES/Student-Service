package com.info.studentservice.service;

import com.info.studentservice.dto.StudentResponse;
import com.info.studentservice.entity.Student;
import com.info.studentservice.entity.Subject;
import com.info.studentservice.repository.StudentRepository;
import com.info.studentservice.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * this class implements service interface for create Student business logics.
 * */

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectRepository subjectRepo;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentBySid(Long id) {
        return studentRepository.findBySid(id);
    }

    @Override
    public StudentResponse getStudentWithSubject(String studentName) {

        Student student = studentRepository.findByName(studentName);
        if(student!=null){
            List<Subject> subjects = new ArrayList<>(student.getSubjects());
            Map<String, Integer> subjectsMap = new HashMap<>();
            for (Subject subject : subjects) {
                subjectsMap.put(subject.getSubjectName(), subject.getMark());
            }
            List<Map<String, Integer>> subjectList = new ArrayList<>();
            subjectList.add(subjectsMap);
            return new StudentResponse(student.getName(), student.getAge(), student.getAddress(), subjectList);
        }else{
            throw new NullPointerException(" Student "+studentName+" Not Present into Database please check Correct name of Student");
        }

    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student subjectAssignToStudent(Long studentId, Long subjectId) {
        Student student=studentRepository.findBySid(studentId);
        if(student!=null){
            Subject subject=subjectRepo.findById(subjectId).get();
            if(subject!=null){
                student.addSubject(subject);
                subject.addStudent(student);
                subjectRepo.save(subject);
            }else{
                throw new NullPointerException(" Passed SubjectId "+subjectId+" this id not available for Subject ");
            }
        }else{
            throw new NullPointerException(" Passed StudentId "+studentId+" this id not available for Student ");
        }
        return studentRepository.save(student);
    }
}
