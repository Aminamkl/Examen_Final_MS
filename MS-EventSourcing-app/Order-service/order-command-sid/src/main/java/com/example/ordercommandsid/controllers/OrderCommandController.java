package com.example.ordercommandsid.controllers;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.sid.coreapi.commands.CreateCategoryCommand;
import org.sid.coreapi.commands.CreateOrderCommand;
import org.sid.coreapi.commands.CreateProductCommand;
import org.sid.coreapi.commands.CreateligneCommand;
import org.sid.coreapi.dtos.CategoryRequestDTO;
import org.sid.coreapi.dtos.LigneRequestDTO;
import org.sid.coreapi.dtos.OrderRequestDTO;
import org.sid.coreapi.dtos.ProductRequestDTO;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/orders/command")
public class OrderCommandController
{

    private CommandGateway commandGateway;
    private EventStore eventStore ;

    @PostMapping("/create")
    private CompletableFuture<String> newProduct(@RequestBody OrderRequestDTO request){

        CompletableFuture<String> response = commandGateway.send(new CreateOrderCommand(
                UUID.randomUUID().toString(),
                request.getDate_livraison(),
                request.getDate_cmd(),
                request.getAdress(),
                request.getStatut()
        ));
        return response;
    }

    @GetMapping(path="/eventStore/{orderId}")
    public Stream eventStore (@PathVariable String orderId){
        return  eventStore.readEvents(orderId).asStream();
    }


    @PostMapping("/ligne/create")
    private CompletableFuture<String> newInventory(@RequestBody LigneRequestDTO request){

        CompletableFuture<String> response = commandGateway.send(new CreateligneCommand(
                UUID.randomUUID().toString(),
                request.getPrix(),
                request.getQuantite(),
                request.getRemise()
        ));
        return response;
    }

}
