package com.jesusfingers.fingers.domain.physioTherapist.model.dto

import java.time.LocalTime

data class PtInfoDto(
    val name: String,
    val phone: String,
    val email: String,
    val deleted: Boolean,
    val address: String,
    val eventStartTime: LocalTime,
    val eventEndTime: LocalTime,
    val eventException: String?,
)
