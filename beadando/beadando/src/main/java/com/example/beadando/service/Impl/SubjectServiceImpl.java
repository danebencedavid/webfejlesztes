package com.example.beadando.service.Impl;

import com.example.beadando.entity.Student;
import com.example.beadando.entity.Subject;
import com.example.beadando.repo.SubjectRepo;
import com.example.beadando.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SubjectServiceImpl implements SubjectService {


    @Autowired
    private SubjectRepo subjectRepo;

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepo.findAll();
    }

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepo.save(subject);
    }

    @Override
    public Subject getSubjectByName(String name) {
        return null;
    }

    @Override
    public Subject updateSubject(Subject subject) {
        return null;
    }

    @Override
    public void deleteSubjectByName(String name) {

    }

    @Override
    public List<Subject> getSubjectsByNames(List<String> subjectNames) {
        return subjectRepo.findBySubjectNameIn(subjectNames);
    }

}
