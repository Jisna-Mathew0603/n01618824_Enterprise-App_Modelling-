package com.example.studentenrollmentapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Programs")
public class Program {

    @Id
    private String programCode;

    private String programName;
    private String duration;
    private Double fee;


    public String getProgramCode() {
        return programCode;
    }
    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }
    public String getProgramName() {
        return programName;
    }
    public void setProgramName(String programName) {
        this.programName = programName;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public Double getFee() {
        return fee;
    }
    public void setFee(Double fee) {
        this.fee = fee;
    }
}
