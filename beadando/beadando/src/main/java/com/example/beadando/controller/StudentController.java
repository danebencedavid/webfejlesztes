package com.example.beadando.controller;


import com.example.beadando.entity.Student;
import com.example.beadando.entity.Subject;
import com.example.beadando.service.StudentService;
import com.example.beadando.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;
    private SubjectService subjectService;

    public StudentController(StudentService studentService,SubjectService subjectService) {
        this.studentService = studentService;
        this.subjectService = subjectService;
    }


    @GetMapping("/students")
    public String listStudent(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        List<Subject> subjects = subjectService.getAllSubjects();

        model.addAttribute("student", student);
        model.addAttribute("subjects", subjects);

        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                @RequestParam(name = "subjects") List<String> subjectNames,
                                Model model) {

        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // Retrieve the selected subjects by names
        List<Subject> selectedSubjects = subjectService.getSubjectsByNames(subjectNames);

        // Assign the subjects to the student
        existingStudent.setSubjects(new HashSet<>(selectedSubjects));

        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }


    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}