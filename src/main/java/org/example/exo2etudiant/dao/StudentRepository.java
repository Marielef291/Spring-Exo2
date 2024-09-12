package org.example.exo2etudiant.dao;

import org.example.exo2etudiant.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByLastname(String lastname);

}
