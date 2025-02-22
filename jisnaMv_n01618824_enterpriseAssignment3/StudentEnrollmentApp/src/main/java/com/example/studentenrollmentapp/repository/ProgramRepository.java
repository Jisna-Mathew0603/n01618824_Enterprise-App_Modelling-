package com.example.studentenrollmentapp.repository;

import com.example.studentenrollmentapp.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program, String> {
}
