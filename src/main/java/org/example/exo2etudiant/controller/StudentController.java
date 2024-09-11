package org.example.exo2etudiant.controller;

import jakarta.validation.Valid;
import org.example.exo2etudiant.model.Student;
import org.example.exo2etudiant.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String detail(@PathVariable("studentID") UUID id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "detail";
    }

    @RequestMapping("/search") // /search?name=Toto
    public String searchStudent(@RequestParam(name = "name", required = false) String name, Model model) {
        List<Student> student = studentService.getStudentsByLastname(name);
        model.addAttribute("students", student);
        return "listStudent";
    }

    @RequestMapping("/add")
    public String formulaire(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("isUpdate", false);
        return "formStudent";
    }

//    @PostMapping("/add")
//    public String submitStudent(@ModelAttribute("student") Student student){
//        studentService.addStudent(student);
//
//        return "redirect:/listStudent";
//    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("studentID") UUID id) {
        System.out.println("delete");
        studentService.deleteStudent(id);
        return "redirect:/listStudent";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("studentID") UUID id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("isUpdate", true);
        return "formStudent";
    }

//    @PostMapping("/update")
//    public String submitUpdateStudent(@RequestParam("studentID") UUID id, @ModelAttribute("student") Student student){
//        student.setId(id);
//        studentService.updateStudent(student);
//        return "redirect:/listStudent";
//    }

    @PostMapping("/save")
    public String saveStudent(

            @Valid @ModelAttribute("student") Student student,
            Model model,
            BindingResult bindingResult) {

        System.out.println(student);
        if (bindingResult.hasErrors()) {
            model.addAttribute("student", new Student());
            model.addAttribute("isUpdate", false);

//            model.addAttribute("isUpdate", student.getId() != null);  // Si l'ID est présent, c'est une mise à jour
            return "formStudent";  // Retourne à la page du formulaire
        } else {
            // Si aucune erreur, sauvegardez l'étudiant
            studentService.saveOrUpdateStudent(student);
            return "redirect:/listStudent";
        }
    }


}
