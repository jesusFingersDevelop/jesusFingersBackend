package com.jesusfingers.fingers.domain.reservation.model.dto

import java.time.LocalDateTime

data class CreateReservationDto(
    val userId: Long,
    val ptId: Long,
    val eventTypeId: Long,
    val startAt: LocalDateTime
)
