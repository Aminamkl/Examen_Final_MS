package org.sid.coreapi.commands

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.Date

abstract class BaseCommand<T>(
        @TargetAggregateIdentifier
        open val id: T

)

/// Customers

data class CreateCustomerCommand(
        override val id: String,
        val name: String,
        val email: String,
        val description: String
) : BaseCommand<String>(id)


data class UpdateCustomerCommand(
        override val id: String,
        val name: String,
        val email: String,
        val description: String
) : BaseCommand<String>(id)

//Product

data class CreateProductCommand(
        override val id: String,
        val name: String,
        val prix: Double,
        val quantite: Int,
        //val etat : String
) : BaseCommand<String>(id)


data class UpdateProductCommand(
        override val id: String,
        val name: String,
        val prix: Double,
        val quantite: Int,
        //val etat : String
) : BaseCommand<String>(id)


//Category
data class CreateCategoryCommand(
        override val id: String,
        val name: String,
        val email: String
) : BaseCommand<String>(id)


data class UpdateCategoryCommand(
        override val id: String,
        val name: String,
        val email: String
) : BaseCommand<String>(id)


// Commande

data class CreateOrderCommand(
        override val id: String,
        val date_cmd: Date,
        val date_livraison: Date,
        val adress: String,
        val statut : String,
) : BaseCommand<String>(id)


data class UpdateOrderCommand(
        override val id: String,
        val date_cmd: Date,
        val date_livraison: Date,
        val adress: String,
        val statut : String,
) : BaseCommand<String>(id)


// ligne_Command


data class CreateligneCommand(
        override val id: String,
        val prix: Double,
        val quantite: Int,
        val remise : String
) : BaseCommand<String>(id)


data class UpdateligneCommand(
        override val id: String,
        val prix: Double,
        val quantite: Int,
        val remise : String
) : BaseCommand<String>(id)
