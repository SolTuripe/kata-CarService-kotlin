package com.carservice.kata.model

class Car(private var id: Long, private var model: String, private var plate: String) {
    fun getId(): Long {
        return id
    }
}