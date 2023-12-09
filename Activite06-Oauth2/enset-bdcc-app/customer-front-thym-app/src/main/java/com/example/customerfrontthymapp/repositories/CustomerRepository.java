package com.example.customerfrontthymapp.repositories;

import com.example.customerfrontthymapp.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
