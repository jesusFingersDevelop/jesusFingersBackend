package com.jesusfingers.fingers

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class FingersApplication

fun main(args: Array<String>) {
	runApplication<FingersApplication>(*args)
}
