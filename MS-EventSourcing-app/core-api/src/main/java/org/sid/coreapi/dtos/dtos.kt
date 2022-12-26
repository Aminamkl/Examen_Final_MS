package org.sid.coreapi.dtos

import java.util.*


data class CustomerRequestDTO(
        var name: String="",
        var email: String="",
        var description: String=""

)

data class ProductRequestDTO(
        var name: String="",
        var prix: Double=0.0,
        var quantite: Int=0,
        //var etat: String=""

)

data class CategoryRequestDTO(
        var id: String="",
        var name: String="",
        var description: String=""

)

data class OrderRequestDTO(
        var id: String="",
        var date_cmd: Date,
        var date_livraison: Date,
        var adress: String="",
        var statut : String="",

        )

data class LigneRequestDTO(
        var id: String="",
        var prix: Double=0.0,
        var quantite: Int=0,
        var remise : String=""

)
