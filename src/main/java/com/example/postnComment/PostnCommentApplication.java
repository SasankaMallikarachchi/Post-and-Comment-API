package com.example.postnComment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PostnCommentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostnCommentApplication.class, args);
	}

}
