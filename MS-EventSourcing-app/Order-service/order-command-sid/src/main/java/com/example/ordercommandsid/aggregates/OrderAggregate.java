package com.example.ordercommandsid.aggregates;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.sid.coreapi.commands.CreateOrderCommand;
import org.sid.coreapi.commands.CreateProductCommand;
import org.sid.coreapi.commands.OrderCreatedEvent;
import org.sid.coreapi.commands.ProductCreatedEvent;

import java.util.Date;

@Aggregate
@Slf4j
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;
    private Date date_cmd;
    private Date date_livraison;
    private String adress;
    private String statut;

    public OrderAggregate() {
    }

    @CommandHandler
    public OrderAggregate(CreateOrderCommand command){
        log.info("OrderCreatedEvent received!!!!");
        AggregateLifecycle.apply(new OrderCreatedEvent(
                command.getId(),
                command.getDate_livraison(),
                command.getDate_cmd(),
                command.getAdress(),
                command.getStatut()
        ));
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event){
        log.info("OrderCreatedEvent occured!!!!");
        this.orderId = event.getId();
        this.date_livraison=event.getDate_livraison();
        this.date_cmd=event.getDate_cmd();
        this.adress=event.getAdress();
        this.statut= event.getStatut();
    }


}
