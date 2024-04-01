package com.example.runner;

import com.example.runner.run.Location;
import com.example.runner.run.Run;
import jakarta.faces.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RunnerApplication {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(RunnerApplication.class, args);
		log.info("Started Successfully");
	}
	@Bean
	CommandLineRunner runner()
	{
		return args -> {
			Run run= new Run(1,"Park", 0,0,10, Location.INDOOR);
			log.info("Run: " + run);
		};
	}

}
