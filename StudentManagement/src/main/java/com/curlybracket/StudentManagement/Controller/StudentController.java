package com.curlybracket.StudentManagement.Controller;
import java.util.ArrayList;
import java.util.List;
import com.curlybracket.StudentManagement.Model.Student;
import com.curlybracket.StudentManagement.Service.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService=studentService;
    }
    private List<Student> students= new ArrayList<>();

    @GetMapping("/student")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    //@GetMapping("/student/{id}")
    public Student getStudentByID (@PathVariable int id) {
        for(Student student : students) {
            if(student.getId() ==id) {
                return student;
            }
        }
        return null;
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id) {

        Student studentToRemove= null;
        for (Student student : students) {
            if (student.getId() == id) {
                studentToRemove = student;
            }
        }
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            return "Student Deleted Successfully";
        }
        return "Student Not Found";
    }

    @PutMapping("/student/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {

        for(Student student: students) {
            if (student.getId()==id) {
                student.setName(updatedStudent.getName());
                student.setAge(updatedStudent.getAge());

                return "Student Updated Successfully";
            }
        }
        return "Student Not Found";
    }
}