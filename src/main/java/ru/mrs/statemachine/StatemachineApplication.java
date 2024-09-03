package ru.mrs.statemachine;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StatemachineApplication //implements CommandLineRunner
{

	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
//		SpringApplication.run(StatemachineApplication.class, args);
		context = new SpringApplicationBuilder(StatemachineApplication.class)
//				.web(WebApplicationType.NONE) // .REACTIVE, .SERVLET
				.run(args);
		System.out.println("Boot Statemachine Application");
	}

}
