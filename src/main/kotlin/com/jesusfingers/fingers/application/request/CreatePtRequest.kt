package com.jesusfingers.fingers.application.request

import java.time.LocalTime

data class CreatePtRequest(
    val name: String,
    val phone: String,
    val email: String,
    val password: String,
    val address: String,
    val workStartTime: LocalTime?,
    val workEndTime: LocalTime?,
    val workException: String?,
)