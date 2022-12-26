package com.example.inventorycommandsid.aggregates;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.sid.coreapi.commands.CreateCustomerCommand;
import org.sid.coreapi.commands.CreateProductCommand;
import org.sid.coreapi.commands.CustomerCreatedEvent;
import org.sid.coreapi.commands.ProductCreatedEvent;

@Aggregate
@Slf4j
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private double prix;

    private int quantite;
    private String etat;

    public ProductAggregate() {
    }

    @CommandHandler
    public ProductAggregate(CreateProductCommand command){
        log.info("CustomerCreatedEvent received!!!!");
        AggregateLifecycle.apply(new ProductCreatedEvent(
                command.getId(),
                command.getName(),
                command.getPrix()
                //command.getEtat()
        ));
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event){
        log.info("CustomerCreatedEvent occured!!!!");
        this.productId = event.getId();
        this.name=event.getName();
        this.prix=event.getPrix();
        //this.etat=event.getEtat();
    }


}
