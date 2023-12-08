package com.example.beadando.service;

import com.example.beadando.entity.Student;
import com.example.beadando.entity.Subject;

import java.util.List;

public interface SubjectService {

    List<Subject> getAllSubjects();

    Subject saveSubject(Subject subject);

    Subject getSubjectByName(String name);

    Subject updateSubject(Subject subject);


    void deleteSubjectByName(String name);

    List<Subject> getSubjectsByNames(List<String> subjectNames);

}
