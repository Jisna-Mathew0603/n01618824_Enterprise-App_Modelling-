package com.example.studentenrollmentapp.controller;

import com.example.studentenrollmentapp.entity.*;
import com.example.studentenrollmentapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class EnrollmentController {

    // Repositories
    private final StudentRepository studentRepository;
    private final ProgramRepository programRepository;
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentController(StudentRepository studentRepository,
                                ProgramRepository programRepository,
                                EnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.programRepository = programRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

 
    @GetMapping("/")
    public String landingPage() {
        return "index";
    }

    // Display login page
    @GetMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    // Display registration page
    @GetMapping("/registerPage")
    public String registerPage(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    //  registration form submission
    @PostMapping("/register")
    public String register(@ModelAttribute Student student, Model model) {
        studentRepository.save(student);
        model.addAttribute("message", "Registration successful! Please login.");
        return "login";
    }

    // login form submission
    @PostMapping("/login")
    public String login(@RequestParam String userName,
                        @RequestParam String password,
                        Model model) {
        Student student = studentRepository.findByUserName(userName);
        if (student != null && student.getPassword().equals(password)) {
            prepareModelForProgram(model, student);
            return "program";
        } else {
            model.addAttribute("error", "Invalid credentials, please enter valid credentials!");
            return "login";
        }
    }

    private void prepareModelForProgram(Model model, Student student) {
        model.addAttribute("student", student);
        List<Program> programs = programRepository.findAll();
        model.addAttribute("programs", programs);
        List<Enrollment> currentEnrollments = enrollmentRepository.findByStudentStudentId(student.getStudentId());
        model.addAttribute("currentEnrollments", currentEnrollments);
    }

    @PostMapping("/selectProgram")
    public String selectProgram(@RequestParam Long studentId,
                                @RequestParam String programCode,
                                Model model) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Program program = programRepository.findById(programCode).orElse(null);
        
        if (student != null && program != null) {
            model.addAttribute("student", student);
            model.addAttribute("program", program);
            return "checkout";
        } else {
            model.addAttribute("error", "Invalid student or program selection!");
            return "program";
        }
    }

    // Process dummy payment and create enrollment
    @PostMapping("/processPayment")
    public String processPayment(@RequestParam Long studentId,
                                 @RequestParam String programCode,
                                 Model model) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Program program = programRepository.findById(programCode).orElse(null);
        
        if (student != null && program != null) {
            createAndSaveEnrollment(student, program);
            model.addAttribute("message", "Payment successful! Your enrollment is successfully confirmed.");
            return "confirmation";
        } else {
            model.addAttribute("error", "Payment failed|! please try again later");
            return "checkout";
        }
    }

    private void createAndSaveEnrollment(Student student, Program program) {
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setProgram(program);
        enrollment.setStartDate(new Date());
        enrollment.setAmountPaid(program.getFee());
        enrollment.setStatus("PAID");
        enrollmentRepository.save(enrollment);
    }

    @GetMapping("/profile/{studentId}")
    public String profile(@PathVariable Long studentId, Model model) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            model.addAttribute("student", student);
            return "profile";
        } else {
            return "redirect:/login";
        }
    }

    // Display profile page for viewing and for crud operation 
    @PostMapping("/updateProfile")
    public String updateProfile(@ModelAttribute Student student, Model model) {
        Student existingStudent = studentRepository.findById(student.getStudentId()).orElse(null);
        if (existingStudent != null) {
            student.setPassword(existingStudent.getPassword());
            studentRepository.save(student);
            model.addAttribute("student", student);
            model.addAttribute("message", "Profile updated successfully.");
            return "profile";
        } else {
            model.addAttribute("error", "Student not found.");
            return "redirect:/login";
        }
    }
}
