package com.info.studentservice.dto;

import java.util.List;
import java.util.Map;

/**
 *
 * DTO used for generated required Output having student details and subject details.
 *
 * */

public class StudentResponse {
    private String name;
    private int age;
    private String address;
    private List<Map<String, Integer>> subjects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Map<String, Integer>> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Map<String, Integer>> subjects) {
        this.subjects = subjects;
    }

    public StudentResponse(String name, int age, String address, List<Map<String, Integer>> subjects) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.subjects = subjects;
    }

    public StudentResponse() {
    }
}
