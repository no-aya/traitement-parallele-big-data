package com.example.orderservice;


import com.example.orderservice.entities.Order;
import com.example.orderservice.entities.ProductItem;
import com.example.orderservice.enums.OrderStatus;
import com.example.orderservice.model.Customer;
import com.example.orderservice.model.Product;
import com.example.orderservice.repositories.OrderRepository;
import com.example.orderservice.repositories.ProductItemRepository;
import com.example.orderservice.services.CustomerRestClientService;
import com.example.orderservice.services.InventoryRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start (
            OrderRepository orderRepository,
            ProductItemRepository productItemRepository,
            CustomerRestClientService customerRestClientService,
            InventoryRestClientService inventoryRestClientService) {
        return args -> {
            Collection<Customer> customers = customerRestClientService.allCustomers().getContent();
            //List<Customer> customers = customerRestClientService.allCustomers().getContent().toList();
            Collection<Product> products = inventoryRestClientService.allProducts().getContent();

            //Pour chercher un client par son id
            Long id = 1L;
            Customer customer = customerRestClientService.customerById(id);
            for (int i=0; i<20;i++) {
                Order order = new Order();
                order.setCustomerId(customer.getId());
                order.setStatus(OrderStatus.values()[(int) (Math.random() * OrderStatus.values().length)]);
                orderRepository.save(order);
                products.forEach(p -> {
                    ProductItem productItem = new ProductItem();
                    productItem.setQuantity(1 + (int) (Math.random() * 100));
                    productItem.setProduct(p);
                    productItem.setOrder(order);
                    productItemRepository.save(productItem);
                });

            }
        };
    }

    }