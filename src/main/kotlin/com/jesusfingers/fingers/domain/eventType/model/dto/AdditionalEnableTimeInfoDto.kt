package com.jesusfingers.fingers.domain.eventType.model.dto

import java.time.LocalDateTime

data class AdditionalEnableTimeInfoDto(
    val eventTypeId: Long,
    val startDateTime: LocalDateTime,
    val endDateTime: LocalDateTime
)
