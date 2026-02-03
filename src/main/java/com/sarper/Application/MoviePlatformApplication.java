package com.sarper.Application;

import com.sarper.jwt.JwtUtils;
import io.jsonwebtoken.Jwt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EntityScan("com.sarper")
@ComponentScan("com.sarper")
@EnableJpaRepositories("com.sarper")
public class MoviePlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviePlatformApplication.class, args);

	}

}
