package com.example.inventoryquerysid.controllers;


import com.example.inventoryquerysid.entites.Category;
import com.example.inventoryquerysid.entites.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.sid.coreapi.query.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/inventory/query")
public class InventoryQueryController {

    private QueryGateway queryGateway;

    @GetMapping("/products/all")
    public CompletableFuture<List<Product>> products(){
        return queryGateway.query(new GetAllProductsQuery(), ResponseTypes.multipleInstancesOf(Product.class));
    }

    @GetMapping("/product/byId/{id}")
    public CompletableFuture<Product> getProduct(@PathVariable String id){
        return queryGateway.query(new GetProductByIdQuery(id), ResponseTypes.instanceOf(Product.class));
    }

    @GetMapping("/Categories/all")
    public CompletableFuture<List<Category>> categories(){
        return queryGateway.query(new GetAllCategoriesQuery(), ResponseTypes.multipleInstancesOf(Category.class));
    }

    @GetMapping("/gategory/byId/{id}")
    public CompletableFuture<Category> getCategory(@PathVariable String id){
        return queryGateway.query(new GetCategoryByIdQuery(id), ResponseTypes.instanceOf(Category.class));
    }



    @ExceptionHandler
    public ResponseEntity<String> error(Exception ex){
        ResponseEntity<String> responseEntity =new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }



}
