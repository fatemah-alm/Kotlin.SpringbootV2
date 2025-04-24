package com.coded.spring.ordering.users

import jakarta.inject.Named
import org.springframework.security.crypto.password.PasswordEncoder

@Named
class UserService(
    private val userRepository: UsersRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun listUsers(): List<User> = userRepository.findAll().map {
        User(
            name = it.name,
            age=it.age

        )
    }

    fun createUser(name: String,age:Int, username:String,password:String){
        if (password.length < 6) throw InvalidPasswordException()
        val newUser = UserEntity( name=name, age=age, username = username,password=passwordEncoder.encode(password))
        userRepository.save(newUser)
    }

}

data class User(

    val name: String,
    val age: Int,
)

class InvalidPasswordException(message: String = "Password must be at least 6 characters") : RuntimeException(message)
