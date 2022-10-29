package com.example.demo.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {

            Student Mophat = new Student(
                    1L,
                    "Mophat",
                    87L

            );
            Student Martha =  new Student(
                    "Martha",
                    87L

            );

            repository.saveAll(
                    List.of(Mophat, Martha)
            );
        };
    }
}
