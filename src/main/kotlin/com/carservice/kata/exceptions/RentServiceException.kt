package com.carservice.kata.exceptions

class RentServiceException(message: String?, val code: String) : RuntimeException(message)