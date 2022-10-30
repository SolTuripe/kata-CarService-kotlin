package com.carservice.kata

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KataApplication

fun main(args: Array<String>) {
	runApplication<KataApplication>(*args)
}
