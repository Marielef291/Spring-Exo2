package org.example.exo2etudiant.controller;

import org.example.exo2etudiant.model.Student;
import org.example.exo2etudiant.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/listStudent")
    public String listStudent(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "listStudent";
    }

    @RequestMapping("detail/{studentID}")
    public String detail(@PathVariable ("studentID") UUID id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "detail";
    }

    @RequestMapping("/search") // /search?name=Toto
    public String searchStudent(@RequestParam(name = "name", required = false) String name, Model model){
        List<Student> student = studentService.getStudentsByLastname(name);
        model.addAttribute("students", student);
        return "listStudent";
    }
    
}
