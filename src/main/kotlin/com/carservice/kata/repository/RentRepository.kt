package com.carservice.kata.repository

import com.carservice.kata.model.Car
import com.carservice.kata.model.Rent
import java.util.*

interface RentRepository {
    fun findRentByCar(car: Car?): Optional<Rent>
    fun save(rent: Rent): Rent
}