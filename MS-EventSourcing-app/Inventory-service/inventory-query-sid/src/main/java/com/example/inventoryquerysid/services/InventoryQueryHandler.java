package com.example.inventoryquerysid.services;


import com.example.inventoryquerysid.entites.Category;
import com.example.inventoryquerysid.entites.Product;
import com.example.inventoryquerysid.respositories.CategoryRepository;
import com.example.inventoryquerysid.respositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.sid.coreapi.query.GetAllCustomersQuery;
import org.sid.coreapi.query.GetCategoryByIdQuery;
import org.sid.coreapi.query.GetCustomerByIdQuery;
import org.sid.coreapi.query.GetProductByIdQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class InventoryQueryHandler {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;


    @QueryHandler
    public List<Product> productsList(GetAllCustomersQuery query){
        return productRepository.findAll();
    }

    @QueryHandler
    public List<Category> categoriesList(GetAllCustomersQuery query){
        return categoryRepository.findAll();
    }

    @QueryHandler
    public Product getProduct(GetProductByIdQuery query){
        return productRepository.findById(query.getId())
                .orElseThrow(()-> new RuntimeException("Product Not Found"));
    }


    @QueryHandler
    public Product getCategory(GetCategoryByIdQuery query){
        return productRepository.findById(query.getId())
                .orElseThrow(()-> new RuntimeException("Category Not Found"));
    }

}

