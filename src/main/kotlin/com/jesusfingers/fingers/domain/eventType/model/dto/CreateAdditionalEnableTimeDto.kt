package com.jesusfingers.fingers.domain.eventType.model.dto

import java.time.LocalDate
import java.time.LocalTime

data class CreateAdditionalEnableTimeDto(
    val eventTypeId: Long,
    val date: LocalDate,
    val startTime: LocalTime,
    val endTime: LocalTime,
)
