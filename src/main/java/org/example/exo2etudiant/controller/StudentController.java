package org.example.exo2etudiant.controller;

import jakarta.validation.Valid;
import org.example.exo2etudiant.model.Student;
import org.example.exo2etudiant.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        model.addAttribute("students", studentService.findAll());
        return "listStudent";
    }

    @RequestMapping("detail/{studentID}")
    public String detail(@PathVariable("studentID") int id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "detail";
    }

    @RequestMapping("/search")
    public String searchStudent(@RequestParam(name = "lastname", required = false) String lastname, Model model) {
        List<Student> students = studentService.findByLastname(lastname);
        model.addAttribute("students", students);
        return "listStudent";
    }

    @RequestMapping("/add")
    public String formulaire(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("isUpdate", false);
        return "formStudent";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("studentID") int id) {
        Student student = studentService.findById(id);
        studentService.delete(student);
        return "redirect:/listStudent";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("studentID") int id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        model.addAttribute("isUpdate", true);
        return "formStudent";
    }

    @PostMapping("/save")
    public String saveStudent(@Valid @ModelAttribute("student") Student student,
                              BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            return "formStudent";
        }
        studentService.save(student);
        return "redirect:/listStudent";
    }


    @PostMapping("/update")
    public String updateStudent(@RequestParam("studentID") int id,
                                @Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult,
                                Model model) {
        if (bindingResult.hasErrors()) {
            return "formStudent";
        }
        student.setId(id); // Assurez-vous que l'ID est bien mis à jour
        studentService.save(student);
        return "redirect:/listStudent";
    }

}
