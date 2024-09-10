package org.example.exo2etudiant.service;

import org.example.exo2etudiant.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final Map<UUID, Student> students;

    public StudentService() {
        students = new HashMap<>();

        Student studentA = Student.builder()
                .id(UUID.randomUUID())
                .lastname("Toto")
                .firstname("Bidule")
                .email("toto.bidule@gmail.com")
                .age(18)
                .build();

        Student studentB = Student.builder()
                .id(UUID.randomUUID())
                .lastname("Tata")
                .firstname("Machin")
                .email("tata.machin@gmail.com")
                .age(25)
                .build();

        Student studentC = Student.builder()
                .id(UUID.randomUUID())
                .lastname("Titi")
                .firstname("Chose")
                .email("titi.chose@gmail.com")
                .age(20)
                .build();

        Student studentD = Student.builder()
                .id(UUID.randomUUID())
                .lastname("Toto")
                .firstname("Truc")
                .email("toto.bidule@gmail.com")
                .age(18)
                .build();

        students.put(studentA.getId(), studentA);
        students.put(studentB.getId(), studentB);
        students.put(studentC.getId(), studentC);
        students.put(studentD.getId(), studentD);
    }

    public List<Student> getAllStudents(){
        return students.values().stream().toList();
    }

    public Student getStudentById(UUID id){
        return students.get(id);
    }

    public List<Student> getStudentsByLastname(String lastname) {
        return students.values().stream()
                .filter(student -> student.getLastname().equalsIgnoreCase(lastname))
                .collect(Collectors.toList());
    }
}
