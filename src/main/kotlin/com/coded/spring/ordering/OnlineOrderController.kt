package com.coded.spring.ordering


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OnlineOrderController(
    private val ordersRepository: OrdersRepository
){
    @GetMapping("/home")
    fun onlineOrder() =  "Start Ordering Food!"

    @PostMapping("/orders")
    fun orderFood(@RequestBody request: OrderFoodRequest) = ordersRepository.save(OrderEntity(name = request.name, restaurant=request.restaurant, items=request.items))

}

data class OrderFoodRequest(
    val name: String,
    val restaurant: String,
    val items: Array<String>
)
