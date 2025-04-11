package com.coded.spring.ordering.Orders


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OnlineOrderController(
    private val ordersService: OrdersService,

){
    @GetMapping("/home")
    fun onlineOrder() =  "Start Ordering Food!"

    @GetMapping("/orders/v1/orders")
    fun getOrders(): List<Order> = ordersService.listOrders()

    @PostMapping("/orders")
    fun orderFood(@RequestBody request: CreateOrderRequest) = ordersService.createOrder(request.userId)

}

data class CreateOrderRequest(
    val userId: Long

)
