package com.carservice.kata.repository

import com.carservice.kata.model.Car
import com.carservice.kata.model.Rent

interface RentRepository {
    fun findRentByCar(car: Car): Rent?

    fun save(rent: Rent): Rent
}