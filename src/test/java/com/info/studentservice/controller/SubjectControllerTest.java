package com.info.studentservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.info.studentservice.entity.Student;
import com.info.studentservice.entity.Subject;
import com.info.studentservice.service.SubjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class SubjectControllerTest {
    @InjectMocks
    SubjectController subjectController;
    @Mock
    SubjectService subjectService;
    String subjectName = "sample";
    int mark = 1;
    Long id = 1l;
    Subject subjectRequest = new Subject(id, subjectName, mark, new HashSet<Student>());
    Subject subjectResponse = new Subject(id, subjectName, mark, new HashSet<Student>());
    List<Subject> subjectList = new ArrayList<>();

    @BeforeEach
    protected void performAdditionalSetUp() {
        subjectList.add(subjectResponse);
        lenient().when(subjectService.saveSubject(subjectRequest)).thenReturn(subjectResponse);
        lenient().when(subjectService.getSubjectById(id)).thenReturn(subjectResponse);
        lenient().when(subjectService.getAllSubjects()).thenReturn(subjectList);
    }

    @Test
    void testSaveSubject() throws JsonProcessingException {
        ResponseEntity<Subject> response = subjectController.saveSubject(subjectRequest);
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    void testGetSubjects() throws JsonProcessingException {
        ResponseEntity<List<Subject>> response = subjectController.getSubjects();
        Assertions.assertNotNull(response.getBody());
    }


}
