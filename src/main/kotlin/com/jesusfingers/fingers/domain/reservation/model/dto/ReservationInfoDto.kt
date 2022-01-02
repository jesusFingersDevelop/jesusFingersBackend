package com.jesusfingers.fingers.domain.reservation.model.dto

import com.jesusfingers.fingers.domain.eventType.model.entity.EventType
import com.jesusfingers.fingers.domain.user.model.entity.User
import java.time.LocalDateTime

data class ReservationInfoDto(
    val startAt: LocalDateTime,
    val isConfirmed: Boolean,
    val eventTypeId: EventType,
    val userId: User,
)
