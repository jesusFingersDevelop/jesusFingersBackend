package com.jesusfingers.fingers.domain.physioTherapist.model.dto

import java.time.LocalTime

data class PtEventInfoDto(
    val eventStartTime: LocalTime,
    val eventEndTime: LocalTime,
    val eventException: String,
)
