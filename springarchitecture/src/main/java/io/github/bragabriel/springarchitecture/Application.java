package io.github.bragabriel.springarchitecture;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);

		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);

		builder.bannerMode(Banner.Mode.OFF); //turning off the Spring Banner

		builder.profiles("prod", "qa"); //setting profiles

		builder.run(args); //running the application, same as the commented line above: SpringApplication.run(...)

		//getting the application context after starting
		ConfigurableApplicationContext applicationContext = builder.context(); //getting the application context
		//var myBean = applicationContext.getBean("myBeanRepository");

		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String applicationName = environment.getProperty("spring.application.name");
		System.out.println("Application name: " + applicationName);

	}

}
