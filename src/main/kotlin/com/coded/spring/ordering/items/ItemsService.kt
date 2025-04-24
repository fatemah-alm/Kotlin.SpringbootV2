package com.coded.spring.ordering.items

import com.coded.spring.ordering.Orders.OrderEntity
import com.coded.spring.ordering.Orders.OrdersRepository
import com.coded.spring.ordering.users.UserEntity
import jakarta.inject.Named
import com.coded.spring.ordering.users.UsersRepository

@Named
class ItemsService(
    private val itemsRepository: ItemsRepository,
    private val ordersRepository: OrdersRepository
) {



    fun addItem( orderId: Long,name: String,quantity: Int){
        val order = ordersRepository.findById(orderId).get()
        val newItem = ItemEntity(name = name, quantity=quantity,order=order)
        itemsRepository.save(newItem)


    }
}


data class Item(
    val userId: Long?,
    val name: String,
    val quantity: Int,
    val orderId: Long

    )