package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Alien;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
		
		/*
		 * Alien a1 = new Alien(); a1.setAname("Tintu");
		 * System.out.println(a1.getAname());
		 */
		 
	}

}
