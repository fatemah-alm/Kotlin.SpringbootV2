package com.coded.spring.ordering.users
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersController(
    val usersRepository: UsersRepository

){
    @GetMapping("/users/v1/users")
    fun getUsers() = usersRepository.findAll()
}


