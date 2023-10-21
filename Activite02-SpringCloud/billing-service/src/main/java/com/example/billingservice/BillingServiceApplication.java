package com.example.billingservice;

import com.example.billingservice.entities.Bill;
import com.example.billingservice.entities.ProductItem;
import com.example.billingservice.feign.CustomerRestClient;
import com.example.billingservice.feign.ProductItemRestClient;
import com.example.billingservice.model.Customer;
import com.example.billingservice.model.Product;
import com.example.billingservice.repositories.BillRepository;
import com.example.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.PagedModel;

import java.util.Collection;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BillRepository billRepository,
							ProductItemRepository productItemRepository,
							CustomerRestClient customerRestClient,
							ProductItemRestClient productItemRestClient) {
		return args -> {
			Customer c1 = customerRestClient.getCustomerById(1L);
			Bill bill =new Bill(null, new Date(), null, c1.getId(), null);
			billRepository.save(bill);
			/*
			System.out.println("***********************");
			System.out.println("ID = " + c1.getId());
			System.out.println("Name = " + c1.getName());
			System.out.println("Email = " + c1.getEmail());
			System.out.println("***********************");
			 */
			PagedModel<Product> productItems = productItemRestClient.pageProducts(0,3);

			productItems.forEach(p -> {
				ProductItem productItem = new ProductItem();
				productItem.setPrice(p.getPrice());
				productItem.setQuantity(1+ (int)(Math.random()*100));
				productItem.setBill(bill);
				productItem.setProductId(p.getId());
				productItemRepository.save(productItem);
			});

			System.out.println("Facture ");
			System.out.println("***********************");
			System.out.println("ID = " + bill.getId());
			System.out.println("Date = " + bill.getBillingDate());
			System.out.println("Customer ID = " + bill.getCustomerId());
			System.out.println("***********************");
			System.out.println("Product Items ");
			System.out.println("***********************");
			Collection<ProductItem> productItems1 = productItemRepository.findByBillId(bill.getId());
			productItems1.forEach(pi -> {
				System.out.println("ID = " + pi.getId());
				System.out.println("Price = " + pi.getPrice());
				System.out.println("Quantity = " + pi.getQuantity());
				System.out.println("Product ID = " + pi.getProductId());
				System.out.println("***********************");
			});

		};
	}
}
