package com.example.studentenrollmentapp;

import com.example.studentenrollmentapp.entity.Program;
import com.example.studentenrollmentapp.repository.ProgramRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentEnrollmentAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentEnrollmentAppApplication.class, args);
    }


    @Bean
    public CommandLineRunner dataLoader(ProgramRepository programRepository) {
        return args -> {
            if(programRepository.count() == 0) {
                Program prog1 = new Program();
                prog1.setProgramCode("SE01");
                prog1.setProgramName("Software Engineering Technology");
                prog1.setDuration("4 years");
                prog1.setFee(20000.00);
                programRepository.save(prog1);

                Program prog2 = new Program();
                prog2.setProgramCode("GD01");
                prog2.setProgramName("Game Development");
                prog2.setDuration("3 years");
                prog2.setFee(18000.00);
                programRepository.save(prog2);

                Program prog3 = new Program();
                prog3.setProgramCode("AI01");
                prog3.setProgramName("Artificial Intelligence");
                prog3.setDuration("2.5 years");
                prog3.setFee(25000.00);
                programRepository.save(prog3);

                Program prog4 = new Program();
                prog4.setProgramCode("BD01");
                prog4.setProgramName("Big Data");
                prog4.setDuration("2 years");
                prog4.setFee(22000.00);
                programRepository.save(prog4);

                Program prog5 = new Program();
                prog5.setProgramCode("ML01");
                prog5.setProgramName("Machine Learning");
                prog5.setDuration("2.5 years");
                prog5.setFee(24000.00);
                programRepository.save(prog5);

            }
        };
    }


}
