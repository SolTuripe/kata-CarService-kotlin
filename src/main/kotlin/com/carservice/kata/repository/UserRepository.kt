package com.carservice.kata.repository

import com.carservice.kata.model.User

interface UserRepository {
    fun findUserById(id: Long): User?
}