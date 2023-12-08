package com.example.beadando;

import com.example.beadando.entity.Student;
import com.example.beadando.entity.Subject;
import com.example.beadando.repo.StudentRepo;
import com.example.beadando.repo.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class BeadandoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BeadandoApplication.class, args);
	}


	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private SubjectRepo subjectRepo;


	@Override
	public void run(String... args) throws Exception {

		Subject math = new Subject("Math");
		Subject history = new Subject("History");
		Subject physics = new Subject("Physics");

		subjectRepo.save(math);
		subjectRepo.save(history);
		subjectRepo.save(physics);

		Set<Subject> student1Subjects = new HashSet<>();
		student1Subjects.add(math);
		student1Subjects.add(history);

		Student student1 = new Student("John", "Doe", "john@example.com", student1Subjects);
		studentRepo.save(student1);

		Set<Subject> student2Subjects = new HashSet<>();
		student2Subjects.add(physics);

		Student student2 = new Student("Jane", "Doe", "jane@example.com", student2Subjects);
		studentRepo.save(student2);



	}
}
