package com.carservice.kata.service

import com.carservice.kata.exceptions.RentServiceException
import com.carservice.kata.repository.CarRepository
import com.carservice.kata.repository.RentRepository
import com.carservice.kata.repository.UserRepository

class RentService(userRepository: UserRepository, carRepository: CarRepository, rentRepository: RentRepository) {
    private var userRepository = userRepository
    private var carRepository = carRepository
    private var rentRepository = rentRepository

    fun rentACar(userId: Long, carId: Long) {

        //find a user
        val userOptional = userRepository.findUserById(userId)
        if(userOptional.isEmpty) {
            throw RentServiceException("Car not found", "U-102")
        }


    }
}

