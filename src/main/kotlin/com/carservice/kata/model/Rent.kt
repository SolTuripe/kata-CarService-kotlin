package com.carservice.kata.model

class Rent(private var rentingId: Long, private var rentingUser: User, private var rentedCar: Car) {

    fun setRentingUser(get: User): User {
        return rentingUser
    }

    fun setRentedCar(get: Car): Car {
        return rentedCar
    }
}