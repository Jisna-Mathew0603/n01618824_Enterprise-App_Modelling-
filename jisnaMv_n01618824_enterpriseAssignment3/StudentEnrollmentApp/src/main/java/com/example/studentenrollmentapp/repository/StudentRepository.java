package com.example.studentenrollmentapp.repository;

import com.example.studentenrollmentapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUserName(String userName);
}
