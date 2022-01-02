package com.jesusfingers.fingers.application.controller

import com.jesusfingers.fingers.domain.eventType.service.EventTypeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/event")
class EventController(private val eventTypeService: EventTypeService) {

    @PostMapping
    fun createEvent() {}

    @GetMapping
    fun getEvent() {}

    @PutMapping
    fun changeEventActiveState() {}

    @PostMapping
    fun createCustomEventTime() {}

    @PutMapping
    fun changeEventTimeType() {}

    @DeleteMapping
    fun deleteEvent() {}
}