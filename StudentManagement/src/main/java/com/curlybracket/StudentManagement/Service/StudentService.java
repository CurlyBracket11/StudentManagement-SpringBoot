package com.curlybracket.StudentManagement.Service;

import com.curlybracket.StudentManagement.Model.Student;
import com.curlybracket.StudentManagement.Repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
}