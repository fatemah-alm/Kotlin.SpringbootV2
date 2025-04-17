package com.coded.spring.ordering.menu


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MenuController(
    private val menuService: MenuService,

    ){

    @GetMapping("/menu/v1/menu")
    fun getMenu(): List<Menu> = menuService.listMenu()

    @PostMapping("/menu/v1/menu")
    fun addToMenu(@RequestBody request: CreateOrderRequest) = menuService.addToMenu(request.name,request.price)

}

data class CreateOrderRequest(
    val name: String,
    val price: Double,

)