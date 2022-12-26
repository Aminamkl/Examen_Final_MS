package org.sid.coreapi.query


class GetAllCustomersQuery {}


data class GetCustomerByIdQuery(
        val id : String
)

class GetAllProductsQuery {}


data class GetProductByIdQuery(
        val id : String
)

class GetAllCategoriesQuery {}


data class GetCategoryByIdQuery(
        val id : String
)

class GetAllOrdersQuery {}


data class GetOrdreByIdQuery(
        val id : String
)

class GetAlllignesQuery {}


data class GetligneByIdQuery(
        val id : String
)
