package com.example.inventorycommandsid.controllers;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.sid.coreapi.commands.CreateCategoryCommand;
import org.sid.coreapi.commands.CreateProductCommand;
import org.sid.coreapi.dtos.CategoryRequestDTO;
import org.sid.coreapi.dtos.ProductRequestDTO;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/intentories/command")
public class InventoryCommandController
{

    private CommandGateway commandGateway;
    private EventStore eventStore ;

    @PostMapping("/product/create")
    private CompletableFuture<String> newProduct(@RequestBody ProductRequestDTO request){

        CompletableFuture<String> response = commandGateway.send(new CreateProductCommand(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getPrix(),
                request.getQuantite()
        ));
        return response;
    }

    @GetMapping(path="/eventStore/product/{productId}")
    public Stream eventStore (@PathVariable String productId){
        return  eventStore.readEvents(productId).asStream();
    }


    @PostMapping("/category/create")
    private CompletableFuture<String> newInventory(@RequestBody CategoryRequestDTO request){

        CompletableFuture<String> response = commandGateway.send(new CreateCategoryCommand(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getDescription()
        ));
        return response;
    }

}
