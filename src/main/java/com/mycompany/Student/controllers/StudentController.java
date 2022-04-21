package com.mycompany.Student.controllers;

import com.mycompany.Student.Services.StudentService;
import com.mycompany.Student.students.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        List<Student> StudentsList = service.listAll();
        model.addAttribute("StudentsList", StudentsList);
        return "students";
    }

    @GetMapping("/students/new")
    public String showNewForm(Model model) {
        model.addAttribute("student",new Student());
        return "student_form";
    }

    @GetMapping("/students/save")
    public String saveUser(Student student, RedirectAttributes ra) {
        service.save(student);
        ra.addFlashAttribute("message","Student Added");
        return "redirect:/students";
    }


}
