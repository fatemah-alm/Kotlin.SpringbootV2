package com.coded.spring.ordering.menu

import jakarta.inject.Named


@Named
class MenuService(
private val menuRepository: MenuRepository
) {

    fun listMenu(): List<Menu> = menuRepository.findAll().map {
        Menu(
            id=it.id,
            name = it.name,
            price = it.price
        )
    }


    fun addToMenu(name: String,price: Double){
        val newItem = MenuEntity(name=name, price = price)
        menuRepository.save(newItem)
    }
}


data class Menu(
    val id:Long?,
    val name: String,
    val price: Double,

)