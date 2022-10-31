package com.carservice.kata.rentService

import com.carservice.kata.exceptions.RentServiceException
import com.carservice.kata.model.Car
import com.carservice.kata.model.Rent
import com.carservice.kata.model.User
import com.carservice.kata.repository.CarRepository
import com.carservice.kata.repository.RentRepository
import com.carservice.kata.repository.UserRepository
import com.carservice.kata.service.RentService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
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

    @Test
    fun `should throw exception if user does not exist`() {
        val user = User(1L, "Rosa")
        val car = Car(1L, "T333", "gogo")

        val rentService = RentService(userRepository, carRepository, rentRepository)

        Mockito.`when`(userRepository.findUserById(user.getId())).thenReturn(Optional.empty())
        Mockito.`when`(carRepository.findCarById(car.getId())).thenReturn(Optional.of(car))

        val thrown: RentServiceException = Assertions.assertThrows(
            RentServiceException::class.java,
            Executable { rentService.rentACar(user.getId(), car.getId()) })

        assertEquals("User not found", thrown.message)
        assertEquals("R-101", thrown.code)
    }

    @Test
    fun `should throw exception if car does not exist`() {
        val user = User(1L, "Rosa")
        val car = Car(1L, "T333", "gogo")

        val rentService = RentService(userRepository, carRepository, rentRepository)

        Mockito.`when`(userRepository.findUserById(user.getId())).thenReturn(Optional.of(user))
        Mockito.`when`(carRepository.findCarById(car.getId())).thenReturn(Optional.empty())

        val thrown: RentServiceException = Assertions.assertThrows(
            RentServiceException::class.java,
            Executable { rentService.rentACar(user.getId(), car.getId()) })

        assertEquals("Car not found", thrown.message)
        assertEquals("U-102", thrown.code)
    }

    @Test
    fun `should throw exception if car exists in rent repository`() {
        val user = User(1L, "Rosa")
        val car = Car(1L, "T333", "gogo")
        val rent = Rent(1, user, car)

        val rentService = RentService(userRepository, carRepository, rentRepository)

        Mockito.`when`(userRepository.findUserById(user.getId())).thenReturn(Optional.of(user))
        Mockito.`when`(carRepository.findCarById(car.getId())).thenReturn(Optional.of(car))
        Mockito.`when`(rentRepository.findRentByCar(car)).thenReturn(Optional.of(rent))
        Mockito.`when`(rentRepository.save(rent)).thenReturn(rent)

        val thrown: RentServiceException = Assertions.assertThrows(
            RentServiceException::class.java,
            Executable { rentService.rentACar(user.getId(), car.getId()) })

        assertEquals("Car is already rented", thrown.message)
        assertEquals("C-103", thrown.code)
    }

}
