package com.carservice.kata.service

import com.carservice.kata.exceptions.RentServiceException
import com.carservice.kata.model.Car
import com.carservice.kata.model.Rent
import com.carservice.kata.model.User
import com.carservice.kata.repository.CarRepository
import com.carservice.kata.repository.RentRepository
import com.carservice.kata.repository.UserRepository

class RentService(private var userRepository: UserRepository, private var carRepository: CarRepository, private var rentRepository: RentRepository) {

    fun rentACar(userId: Long, carId: Long): Rent {

        //find a user
        val userOptional = userRepository.findUserById(userId)
        if(userOptional.isEmpty) {
            throw RentServiceException("User not found", "R-101")
        }

        val carOptional = carRepository.findCarById(carId)
        if(carOptional.isEmpty) {
            throw RentServiceException("Car not found", "U-102")
        }

        val rentOptional = rentRepository.findRentByCar(carOptional.get())
        if(rentOptional.isPresent) {
            throw RentServiceException("Car is already rented", "C-103")
        }

        //create rent item
        val rent = Rent(1, User(1, "rosa"), Car(1, "toyota", "dd33"))
        rent.setRentingUser(userOptional.get())
        rent.setRentedCar(carOptional.get())

        return rentRepository.save(rent)
    }
}

