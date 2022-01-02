package com.jesusfingers.fingers.application.request

import java.time.LocalDateTime

data class CreateReservationRequest(
    val startTime: LocalDateTime,
    val userId: Long,
    val ptId: Long,
    val eventTypeId: Long,
)
