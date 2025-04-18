package com.coded.spring.ordering.users

import jakarta.inject.Named
import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository

@Named
interface UsersRepository : JpaRepository<UserEntity, Long>{
    fun findByUsername(username: String):UserEntity?
}

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,


    var name: String,
    var age: Int,
    var username:String,
    var password:String
){
    constructor() : this(null, "",0,"","")
}