package com.example.studentenrollmentapp.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationNo;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "programCode")
    private Program program;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    private Double amountPaid;
    private String status;

    public Long getApplicationNo() {
        return applicationNo;
    }
    public void setApplicationNo(Long applicationNo) {
        this.applicationNo = applicationNo;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Program getProgram() {
        return program;
    }
    public void setProgram(Program program) {
        this.program = program;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Double getAmountPaid() {
        return amountPaid;
    }
    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
