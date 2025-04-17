package com.coded.spring.ordering.items

import com.coded.spring.ordering.Orders.Order
import com.coded.spring.ordering.Orders.OrdersService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ItemsController(
    private val itemsService: ItemsService,

    ){


//    @GetMapping("/items/v1/items/{orderId}")
//    fun getItems(@PathVariable orderId: Long): List<Item> = itemsService.listItems(orderId)

    @PostMapping("/items/v1/items")
    fun addItem(@RequestBody request: CreateItemRequest) = itemsService.addItem(request.orderId,request.name,request.quantity)

}

data class CreateItemRequest(
    val name: String,
    val quantity: Int,
    val orderId: Long

)