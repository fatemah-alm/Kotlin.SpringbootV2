package com.coded.spring.ordering.users

import com.coded.spring.ordering.Orders.OrderEntity
import jakarta.inject.Named

@Named
class UserService(
    private val userRepository: UsersRepository
) {

    fun listUsers(): List<User> = userRepository.findAll().map {
        User(
            name = it.name,
            age=it.age

        )
    }

    fun createUser(name: String,age:Int){

        val newUser = UserEntity( name=name, age=age)
        userRepository.save(newUser)
    }

}

data class User(

    val name: String,
    val age: Int,
)