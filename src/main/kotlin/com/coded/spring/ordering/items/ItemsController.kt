package com.coded.spring.ordering.items


import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ItemsController(
    private val itemsService: ItemsService,

    ){


    @PostMapping("/items/v1/items")
    fun addItem(@RequestBody request: CreateItemRequest) = itemsService.addItem(request.orderId,request.name,request.quantity)

}

data class CreateItemRequest(
    val name: String,
    val quantity: Int,
    val orderId: Long

)