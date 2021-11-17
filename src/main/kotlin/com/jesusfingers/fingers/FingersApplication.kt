package com.jesusfingers.fingers

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FingersApplication

fun main(args: Array<String>) {
	runApplication<FingersApplication>(*args)
}
