package com.info.studentservice.controller;

import com.info.studentservice.entity.Subject;
import com.info.studentservice.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * This Rest Controller Handle Subject Operations.
 * End Points :- Here you can add Subject, Get Student, Get All Subject List.
 *
 * */

@RestController
@RequestMapping("/subjectDetails")
public class SubjectController {

    /**
     * Autowired Subject Service.
     * Subject Service Provide implementation of business logics.
     * */
    @Autowired
    SubjectService subjectService;

    /**
     * Description :- this end point use for add/save new Subject into database.
     * Parameter :- Rest Api accept Subject Object. like subjectName,mark.
     * Operation :- we will pass subjectName,mark for add/save subject.
     *              id will be auto generated we will not pass id in JSON.
     * Output :- Rest Api return newly created subject object. it will have id,subjectName,mark.
     * */
    @PostMapping("/save")
    public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject){
        return new ResponseEntity<>(subjectService.saveSubject(subject), HttpStatus.OK);
    }

    /**
     * Description :- this end point use for get all Subject into database.
     * Parameter :- No needed any Parameter
     * Operation :- we will give All subject list.
     * Output :- Rest Api return all subject list. it will have id,subjectName,mark.
     * */
    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getSubjects(){
        return new ResponseEntity<>(subjectService.getAllSubjects(), HttpStatus.OK);
    }
}
