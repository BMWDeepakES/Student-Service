package com.info.studentservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.info.studentservice.dto.StudentResponse;
import com.info.studentservice.entity.Student;
import com.info.studentservice.entity.Subject;
import com.info.studentservice.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.lenient;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @InjectMocks
    StudentController studentController;
    @Mock
    StudentService studentService;
    String name="sample";
    int age=1;
    Long id=1l;
    String address="sample";
    String subject="sample";
    int mark=1;
    Student studentRequest=new Student(id,name,age,address,new HashSet<Subject>());
    Student studentResponse=new Student(id,name,age,address,new HashSet<Subject>());
    List<Student> studentList=new ArrayList<>();
    List<Map<String,Integer>> subjectmapList=new ArrayList<>();
    Map<String,Integer> subjectMap=new HashMap<>();
    StudentResponse studentResponse1=new StudentResponse(name,age,address,subjectmapList);
    @BeforeEach
    protected void performAdditionalSetUp()  {
        studentList.add(studentRequest);
        subjectMap.put(subject,mark);
        subjectmapList.add(subjectMap);
        lenient().when(studentService.saveStudent(studentRequest)).thenReturn(studentResponse);
        lenient().when(studentService.getAllStudent()).thenReturn(studentList);
        lenient().when(studentService.getStudentBySid(id)).thenReturn(studentResponse);
        lenient().when(studentService.getStudentWithSubject(name)).thenReturn(studentResponse1);
        lenient().when(studentService.subjectAssignToStudent(id,id)).thenReturn(studentResponse);
    }

    @Test
    void testSaveStudent() throws JsonProcessingException {
        ResponseEntity<Student> response = studentController.saveStudent(studentRequest);
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    void testGetStudentWithSubject() throws JsonProcessingException {
        ResponseEntity<?> response = studentController.getStudentWithSubject(name);
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    void testAssignSubjectToStudent() throws JsonProcessingException {
        ResponseEntity<?> response = studentController.assignSubjectToStudent(id,id);
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    void testGetStudents() throws JsonProcessingException {
        ResponseEntity<List<Student>> response = studentController.getStudents();
        Assertions.assertNotNull(response.getBody());
    }
}
