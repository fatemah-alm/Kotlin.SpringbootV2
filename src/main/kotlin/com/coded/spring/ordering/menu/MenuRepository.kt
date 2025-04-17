package com.coded.spring.ordering.menu


import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository

interface MenuRepository: JpaRepository<MenuEntity, Long>{
}

@Entity
@Table(name="menu")
data class MenuEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val price: Double,

){
    constructor() : this(null, "", 0.0)
}