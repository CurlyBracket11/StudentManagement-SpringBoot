package com.curlybracket.StudentManagement.Controller;
import java.util.ArrayList;
import java.util.List;
import com.curlybracket.StudentManagement.Model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class StudentController {
    private List<Student> students= new ArrayList<>();

    public StudentController() {
        students.add(new Student(1,"Bhumi",19));
        students.add(new Student(2,"Rahul",20));
        students.add(new Student(3,"Aman",21));
    }

    @GetMapping("/student")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/student")
    public String addStudent(@RequestBody Student student) {
        students.add(student);
        return "Student Added Successfull";
    }
}
