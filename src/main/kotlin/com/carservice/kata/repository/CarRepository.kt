package com.carservice.kata.repository

import com.carservice.kata.model.Car

interface CarRepository {
    fun findCarById(id: Long): Car?
}