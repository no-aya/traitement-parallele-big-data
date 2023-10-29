package com.example.customerservice;

import com.example.customerservice.entities.Customer;
import com.example.customerservice.pepo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.saveAll(List.of(
                    customerRepository.save(new Customer(null, "Hassan", "@a.com")),
                    customerRepository.save(new Customer(null, "Hassan", "@a.com"))
            ));
            customerRepository.findAll().forEach(System.out::println);
        };
    }
}
