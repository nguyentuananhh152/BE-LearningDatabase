package com.example.learningdatabase;

import com.example.learningdatabase.entity.User;
import com.example.learningdatabase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaRepositories
public class LearningDatabaseApplication {
	public static void main(String[] args) {
		SpringApplication.run(LearningDatabaseApplication.class, args);
	}


}
