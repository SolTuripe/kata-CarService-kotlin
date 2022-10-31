package com.carservice.kata.model

class User(id: Long, name: String) {
    private var id = id
    private var name = name

    fun getId(): Long {
        return id
    }
}