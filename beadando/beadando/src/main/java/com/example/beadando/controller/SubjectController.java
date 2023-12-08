package com.example.beadando.controller;


import com.example.beadando.entity.Student;
import com.example.beadando.entity.Subject;
import com.example.beadando.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubjectController {

    
    private SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subjects")
    public String listSubject(Model model){
        model.addAttribute("subjects",subjectService.getAllSubjects());
        return "subjects";
    }

    @GetMapping("/subjects/new")
    public String createSubjectForm(Model model) {
        Subject subject = new Subject();
        model.addAttribute("subject", subject);
        return "create_subject";
    }


    @PostMapping("/subjects")
    public String saveSubject(@ModelAttribute("student") Subject subject) {
        subjectService.saveSubject(subject);
        return "redirect:/subjects";
    }

    @GetMapping("/subjects/edit/{subjectName}")
    public String editSubjectForm(@PathVariable String subjectName, Model model) {
        model.addAttribute("subject", subjectService.getSubjectByName(subjectName));
        return "edit_subject";
    }

    @PostMapping("/subjects/{subjectName}")
    public String updateSubject(@PathVariable String subjectName,
                                @ModelAttribute("subject") Subject subject,
                                Model model) {

        Subject existingSubject = subjectService.getSubjectByName(subjectName);
        existingSubject.setSubjectName(subjectName);

        subjectService.updateSubject(existingSubject);
        return "redirect:/subjects";
    }

    @GetMapping("/subjects/{subjectName}")
    public String deleteSubject(@PathVariable String subjectName) {
        subjectService.deleteSubjectByName(subjectName);
        return "redirect:/subjects";
    }

}
