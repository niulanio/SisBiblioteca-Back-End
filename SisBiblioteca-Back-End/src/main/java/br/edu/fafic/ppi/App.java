package br.edu.fafic.ppi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
public class App implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//registry.addMapping("/**").allowedMethods("GET, PUT, POST, DELETE, OPTIONS");
		registry.addMapping("/**")
		.allowedMethods("*")
		.allowedOrigins("http://localhost:3000");
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
