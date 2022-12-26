package com.example.inventoryquerysid.services;


import com.example.inventoryquerysid.entites.Product;
import com.example.inventoryquerysid.respositories.CategoryRepository;
import com.example.inventoryquerysid.respositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.sid.coreapi.commands.CustomerCreatedEvent;
import org.sid.coreapi.commands.ProductCreatedEvent;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class InventoryEventHandler {


    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @EventHandler
    public void on(ProductCreatedEvent event){
        log.info("*************");
        log.info("CustomerCreatedEvent received");
        Product customer = new Product();
        customer.setId(event.getId());
        customer.setName(event.getName());
        customer.setPrix(event.getPrix());
        productRepository.save(customer);
    }
}
