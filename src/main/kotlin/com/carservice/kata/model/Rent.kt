package com.carservice.kata.model

class Rent(rentingId: Long, rentingUser: User, rentedCar: Car) {

    private var rentingId = rentingId
    private var rentingUser = rentingUser
    private var rentedCar = rentedCar

    fun setRentingUser(get: User): User {
        return rentingUser
    }

    fun setRentedCar(get: Car): Car {
        return rentedCar
    }
}