package com.carservice.kata.model

import java.util.*


class Rent(rentingId: Long, rentingUser: User, rentedCar: Car, date: Date) {
    private var rentingId = rentingId
    private var rentingUser = rentingUser
    private var rentedCar = rentedCar
    private var date = date
}