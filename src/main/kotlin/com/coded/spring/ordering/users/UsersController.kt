package com.coded.spring.ordering.users
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersController(
    val usersRepository: UsersRepository,
    val usersService: UserService

){
    @GetMapping("/users/v1/users")
    fun getUsers() = usersService.listUsers()

    @PostMapping("/users")
    fun createUser(@RequestBody request: CreateUserRequest) = usersService.createUser(request.name,request.age,request.username,request.password)
}

data class CreateUserRequest(

    var name: String,
    var age: Int,
    var username:String,
    var password:String

)

