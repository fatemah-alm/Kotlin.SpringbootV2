package com.coded.spring.ordering.Orders



import com.coded.spring.ordering.users.UserEntity
import jakarta.inject.Named
import com.coded.spring.ordering.users.UsersRepository

@Named
class OrdersService(
    private val ordersRepository: OrdersRepository,
    private val usersRepository: UsersRepository,
) {

    fun listOrders(): List<Order> = ordersRepository.findAll().map {
        Order(
            userId = it.user.id,
            restaurant = it.restaurant
        )
    }


    fun createOrder(userId: Long,restaurant:String){
        val user = usersRepository.findById(userId).get()
        val newOrder = OrderEntity(user=user, restaurant = restaurant)
        ordersRepository.save(newOrder)
    }
    }


data class Order(
    val userId: Long?,
    val restaurant: String

)