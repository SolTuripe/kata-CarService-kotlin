package com.carservice.kata.repository

import com.carservice.kata.model.User
import java.util.*

interface UserRepository {
    fun findUserById(id: Long): Optional<User>
}