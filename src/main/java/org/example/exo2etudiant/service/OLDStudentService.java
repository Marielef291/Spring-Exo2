//package org.example.exo2etudiant.service;
//
//import org.example.exo2etudiant.model.Student;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@Service
//public class StudentService {
//    private final Map<Integer, Student> students;
//
//    public StudentService() {
//        students = new HashMap<>();
//
//        Student studentA = Student.builder()
//                .lastname("Toto")
//                .firstname("Bidule")
//                .email("toto.bidule@gmail.com")
//                .age(18)
//                .build();
//
//        Student studentB = Student.builder()
//                .lastname("Tata")
//                .firstname("Machin")
//                .email("tata.machin@gmail.com")
//                .age(25)
//                .build();
//
//        Student studentC = Student.builder()
//                .lastname("Titi")
//                .firstname("Chose")
//                .email("titi.chose@gmail.com")
//                .age(20)
//                .build();
//
//        Student studentD = Student.builder()
//                .lastname("Toto")
//                .firstname("Truc")
//                .email("toto.bidule@gmail.com")
//                .age(18)
//                .build();
//
//        students.put(studentA.getId(), studentA);
//        students.put(studentB.getId(), studentB);
//        students.put(studentC.getId(), studentC);
//        students.put(studentD.getId(), studentD);
//    }
//
//    public List<Student> getAllStudents(){
//        return students.values().stream().toList();
//    }
//
//    public Student getStudentById(int id){
//        return students.get(id);
//    }
//
//    public List<Student> getStudentsByLastname(String lastname) {
//        return students.values().stream()
//                .filter(student -> student.getLastname().equalsIgnoreCase(lastname))
//                .collect(Collectors.toList());
//    }
//
////    public void addStudent(Student student){
////        if (student.getId() == null) {
////            student.setId(UUID.randomUUID());
////        }
////        students.put(student.getId(), student);
////    }
//
////    public void updateStudent(Student student){
////       Student existingStudent = students.get(student.getId());
////
////       existingStudent.setLastname(student.getLastname());
////       existingStudent.setFirstname(student.getFirstname());
////       existingStudent.setEmail(student.getEmail());
////       existingStudent.setAge(student.getAge());
////       students.put(existingStudent.getId(), existingStudent);
////    }
//
//    public void deleteStudent(int id){
//        students.remove(id);
//    }
//
//    public void saveOrUpdateStudent(Student student) {
//        if (student.getId() == null) {
//            student.setId(int.randomUUID());
//            students.put(student.getId(), student);
//        } else {
//            Student existingStudent = students.get(student.getId());
//
//            if (existingStudent != null) {
//                existingStudent.setLastname(student.getLastname());
//                existingStudent.setFirstname(student.getFirstname());
//                existingStudent.setEmail(student.getEmail());
//                existingStudent.setAge(student.getAge());
//            } else {
//                students.put(student.getId(), student);
//            }
//        }
//    }
//
//}
