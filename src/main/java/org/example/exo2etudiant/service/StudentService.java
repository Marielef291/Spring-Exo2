package org.example.exo2etudiant.service;

import org.example.exo2etudiant.dao.StudentRepository;
import org.example.exo2etudiant.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> findByLastname(String lastname) {
        return studentRepository.findByLastnameContainingIgnoreCase(lastname);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }
    public void delete(Student student) {
        studentRepository.delete(student);
    }
}
