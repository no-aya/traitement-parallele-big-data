package com.example.orderservice.web;

import com.example.orderservice.entities.Order;
import com.example.orderservice.model.Customer;
import com.example.orderservice.model.Product;
import com.example.orderservice.repositories.OrderRepository;
import com.example.orderservice.repositories.ProductItemRepository;
import com.example.orderservice.services.CustomerRestClientService;
import com.example.orderservice.services.InventoryRestClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderRestController {

    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;

    @GetMapping("/fullOrder/{id}")
    public Order getOrder(@PathVariable Long id){
        Order order = orderRepository.findById(id).get();
        Customer customer = customerRestClientService.customerById(order.getCustomerId());

        order.setCustomer(customer);
        order.getItems().forEach(productItem ->{
            Product product = inventoryRestClientService.productById(productItem.getProductId());
            productItem.setProduct(product);
        });
        return order;
    }
}
