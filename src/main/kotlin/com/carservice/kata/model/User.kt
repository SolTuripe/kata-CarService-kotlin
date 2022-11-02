package com.carservice.kata.model

class User(private var id: Long, private var name: String) {

    fun getId(): Long {
        return id
    }
}