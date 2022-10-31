package com.carservice.kata.rentService

import com.carservice.kata.model.Car
import com.carservice.kata.model.Rent
import com.carservice.kata.model.User
import com.carservice.kata.repository.CarRepository
import com.carservice.kata.repository.RentRepository
import com.carservice.kata.repository.UserRepository
import com.carservice.kata.service.RentService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class RentServiceTest {

    @Mock
    private lateinit var userRepository: UserRepository
    @Mock
    private lateinit var carRepository: CarRepository
    @Mock
    private lateinit var rentRepository: RentRepository

    @Test
    fun `can rent a car`(){

        //Given - stage
        val user = User(1L, "Rosa")
        val car = Car(1L, "T333", "gogo")
        val rent = Rent(1, user, car)
        //val rentService = RentService(userRepository, carRepository, rentRepository)

        //When - action
        Mockito.`when`(userRepository.findUserById(user.getId())).thenReturn(Optional.of(user))
        Mockito.`when`(carRepository.findCarById(car.getId())).thenReturn(Optional.of(car))
        Mockito.`when`(rentRepository.findRentByCar(car)).thenReturn(Optional.empty())
        Mockito.`when`(rentRepository.save(rent)).thenReturn(rent)

        //Then - result
        assertEquals(user, userRepository.findUserById(user.getId()).get())
        assertEquals(car, carRepository.findCarById(car.getId()).get())
        assertEquals(rent, rentRepository.save(rent))
    }

}
