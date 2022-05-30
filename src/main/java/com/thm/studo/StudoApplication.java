package com.thm.studo;

import com.thm.studo.student.Student;
import com.thm.studo.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student maria = new Student(
                    "Maria", "Jones", 12345
            );
          studentRepository.save(maria);
        };
    }
}
