package com.info.studentservice.controller;

import com.info.studentservice.entity.Student;
import com.info.studentservice.service.StudentService;
import com.info.studentservice.util.CustomeError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 *
 * This Rest Controller Handle Student Operations.
 * End Points :- Here you can add Student, Get Student with Subject,
 *              see All Student,Assigned subject to Student.
 *
 * */

@RestController
@RequestMapping("/StudentDetails")
public class StudentController {

    /**
    * Autowired Student Service.
     * Student Service Provide implementation of business logics.
    * */
    @Autowired
    StudentService studentService;


    /**
     * Description :- this end point use for add/save new student into database.
     * Parameter :- Rest Api accept Student Object. like name,age,address.
     * Operation :- we will pass name,age,address for add/save student.
     *              id will be auto generated we will not pass id in JSON
     * Output :- Rest Api return newly created student object it have sid,name,age,address.
     * */
    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.OK);
    }

    /**
     * Description :- this end point use for fetch student with subject from database.
     * Parameter :- Rest Api accept String path variable. path variable will be student name.
     * Operation :- we will pass student name for fetch student Details with subject.
     * Output :- Rest Api return Student details with subject if student not present into database.
     *           then it will return student not found message.
     * */
    @GetMapping("/student{studentName}")
    public ResponseEntity<?> getStudentWithSubject(@PathParam("studentName") String studentName) {
        try{
        return new ResponseEntity<>(studentService.getStudentWithSubject(studentName), HttpStatus.OK);
        }catch (NullPointerException e){
           return new ResponseEntity<>(new CustomeError(e.getMessage(),HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Description :- this end point use for assign subject to student. we will pass student id and subject id.
     *                for mapping.
     * Parameter :- Rest Api accept Long studentid and Long subjectid in path variable.
     * Operation :- we will pass studentid and subjectid for map student with subject.
     * Output :- Rest Api return Student details with subject if student not present into database.
     *           then it will return student not found message with that studentId.
     * */
    @PutMapping("addsubject/{studentid}/{subjectid}")
    public ResponseEntity<?> assignSubjectToStudent(@PathVariable("studentid") Long studentId, @PathVariable("subjectid") Long subjectId) {
        try {
            return new ResponseEntity<>(studentService.subjectAssignToStudent(studentId, subjectId), HttpStatus.OK);
           }catch (NullPointerException e){
            return new ResponseEntity<>(new CustomeError(e.getMessage(),HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
          }
    }

    /**
     * Description :- this end point use for fetch all Student details which is available into database.
     * Parameter :- No Parameter needed for this rest api.
     * Operation :- fetch all student details.
     * Output :- Rest Api return all Student details list.
     * */
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }

}
