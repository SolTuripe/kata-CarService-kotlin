package com.carservice.kata.repository

import com.carservice.kata.model.Car
import java.util.*

interface CarRepository {
    fun findCarById(id: Long): Optional<Car>
}