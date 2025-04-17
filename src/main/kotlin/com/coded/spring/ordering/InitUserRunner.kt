package com.coded.spring.ordering

import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

class InitUserRunner{
    @Bean
    fun initUser(){
        TODO()
    }


}

fun main(args: Array<String>){
    runApplication<Application>(*args).close()
}