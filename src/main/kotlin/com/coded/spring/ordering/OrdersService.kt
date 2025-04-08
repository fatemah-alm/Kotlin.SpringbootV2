package com.coded.spring.ordering



import jakarta.inject.Named

@Named
class UsersService(
    private val ordersRepository: OrdersRepository,
) {

    fun listUsers(): List<Order> = ordersRepository.findAll().map {
        Order(
            name = it.name,
            restaurant = it.restaurant,
            items=it.items

        )
    }
}

data class Order(
    val name: String,
    val restaurant: String,
    val items: Array<String>
)