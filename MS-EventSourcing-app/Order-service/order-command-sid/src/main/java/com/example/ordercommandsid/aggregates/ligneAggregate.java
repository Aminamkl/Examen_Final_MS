package com.example.ordercommandsid.aggregates;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.sid.coreapi.commands.CreateProductCommand;
import org.sid.coreapi.commands.CreateligneCommand;
import org.sid.coreapi.commands.ProductCreatedEvent;
import org.sid.coreapi.commands.ligneCreatedEvent;

@Aggregate
@Slf4j
public class ligneAggregate {

    @AggregateIdentifier
    private String ligneId;
    private Double prix;
    private int quantite;
    private String remise;

    public ligneAggregate() {
    }

    @CommandHandler
    public ligneAggregate(CreateligneCommand command){
        log.info("ligneCreatedEvent received!!!!");
        AggregateLifecycle.apply(new ligneCreatedEvent(
                command.getId(),
                command.getPrix(),
                command.getQuantite(),
                command.getRemise()
        ));
    }

    @EventSourcingHandler
    public void on(ligneCreatedEvent event){
        log.info("CustomerCreatedEvent occured!!!!");
        this.ligneId = event.getId();
        this.prix=event.getPrix();
        this.quantite=event.getQuantite();
        this.remise=event.getRemise();
    }


}
