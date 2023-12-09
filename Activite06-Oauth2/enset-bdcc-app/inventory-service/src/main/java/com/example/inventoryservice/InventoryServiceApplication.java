package com.example.inventoryservice;

import com.example.inventoryservice.entities.Product;
import com.example.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder().id("1").name("TV").price(3000.0).quantity(10).build());
            productRepository.save(Product.builder().id("2").name("Radio").price(300.0).quantity(10).build());
            productRepository.save(Product.builder().id("3").name("Computer").price(12000.0).quantity(10).build());
            productRepository.save(Product.builder().id("4").name("Phone").price(8000.0).quantity(10).build());
            productRepository.save(Product.builder().id("5").name("Watch").price(3000.0).quantity(10).build());
        };
    }
}
