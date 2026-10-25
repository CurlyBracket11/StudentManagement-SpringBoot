package com.curlybracket.StudentManagement.Repository;

import com.curlybracket.StudentManagement.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository
extends JpaRepository <Student, Integer> {
}
