package com.example.beadando.entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @Column(name = "subject_name")
    private String subjectName;

    @ManyToMany(mappedBy = "subjects")
    private Set<Student> students = new HashSet<>();


    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public Subject(String subjectName, Set<Student> students) {
        this.subjectName = subjectName;
        this.students = students;
    }

    public Subject() {
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
