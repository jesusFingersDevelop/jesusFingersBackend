package com.jesusfingers.fingers.application.request

data class CreateEventRequest(
    val title: String,
    val description: String,
    val eventType: String,
    val ptId: Long
)
