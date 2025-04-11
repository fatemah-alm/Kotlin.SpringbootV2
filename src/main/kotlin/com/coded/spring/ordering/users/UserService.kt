package com.coded.spring.ordering.users

import jakarta.inject.Named

@Named
class UserService(
    private val userRepository: UsersRepository
) {

    fun listOrders(): List<User> = userRepository.findAll().map {
        User(
            name = it.name,
            age=it.age

        )
    }
}

data class User(
    val name: String,
    val age: Int,
)