package com.example.beadando.repo;

import com.example.beadando.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubjectRepo  extends JpaRepository<Subject,String> {
    List<Subject> findBySubjectNameIn(List<String> subjectNames);

}
