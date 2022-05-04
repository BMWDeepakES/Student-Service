package com.info.studentservice.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity class for Student
 * */

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sid;
    private String name;
    private int age;
    private String address;
    @ManyToMany()
    @JoinTable(
            name = "students",
            joinColumns = @JoinColumn(name = "sid"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private Set<Subject> subjects = new HashSet<>();

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

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

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Student(Long sid, String name, int age, String address, Set<Subject> subjects) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.address = address;
        this.subjects = subjects;
    }

    public Student() {
    }
}