package com.example.customerfrontthymapp;

import com.example.customerfrontthymapp.entities.Customer;
import com.example.customerfrontthymapp.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerFrontThymAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerFrontThymAppApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(Customer.builder().name("John").email("john@mail.com").build());
			customerRepository.save(Customer.builder().name("Smith").email("s@mail.com").build());
			customerRepository.save(Customer.builder().name("Jane").email("jane@mail.com").build());
			customerRepository.findAll().forEach(System.out::println);

		};
	}

}
