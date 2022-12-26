package org.sid.coreapi.commands

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.*

abstract class BaseEvent<T>(
        @TargetAggregateIdentifier
        open val id: T

)
data class CustomerCreatedEvent(
        override val id: String,
        val name: String,
        val email: String,
        val description: String
) : BaseEvent<String>(id)


data class CustomerUpdateEvent(
        override val id: String,
        val name: String,
        val email: String,
        val description: String
) : BaseEvent<String>(id)


//Product

data class ProductCreatedEvent(
        override val id: String,
        val name: String,
        val prix: Double,
        //val etat : String
) : BaseEvent<String>(id)


data class ProductUpdateEvent(
        override val id: String,
        val name: String,
        val prix: Double,
        val quantite: Int,
        val etat : String
) : BaseEvent<String>(id)


//Category
data class CategoryCreatedEvent(
        override val id: String,
        val name: String,
        val email: String
) : BaseEvent<String>(id)


data class CategoryUpdateEvent(
        override val id: String,
        val name: String,
        val email: String
) : BaseEvent<String>(id)


// Orders

data class OrderCreatedEvent(
        override val id: String,
        val date_cmd: Date,
        val date_livraison: Date,
        val adress: String,
        val statut : String,
) : BaseEvent<String>(id)


data class OrderUpdateEvent(
        override val id: String,
        val date_cmd: Date,
        val date_livraison: Date,
        val adress: String,
        val statut : String,
) : BaseEvent<String>(id)


// ligne_Commond


data class ligneCreatedEvent(
        override val id: String,
        val prix: Double,
        val quantite: Int,
        val remise : String
) : BaseEvent<String>(id)


data class ligneUpdateEvent(
        override val id: String,
        val prix: Double,
        val quantite: Int,
        val remise : String
) : BaseEvent<String>(id)
