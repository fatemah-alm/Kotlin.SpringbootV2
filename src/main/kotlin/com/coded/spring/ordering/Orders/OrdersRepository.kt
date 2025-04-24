package com.coded.spring.ordering.Orders


import com.coded.spring.ordering.users.UserEntity
import jakarta.inject.Named
import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository

@Named
interface OrdersRepository : JpaRepository<OrderEntity, Long>

@Entity
@Table(name = "orders")
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    val user: UserEntity,
    val restaurant:String,

//    @OneToMany(mappedBy = "orderId")
//    val items: List<ItemEntity>? = null


    ){
    constructor() : this(null, UserEntity(),"")
}