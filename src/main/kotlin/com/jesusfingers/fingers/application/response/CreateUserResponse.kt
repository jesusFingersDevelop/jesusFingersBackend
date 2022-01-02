package com.jesusfingers.fingers.application.response

data class CreateUserResponse(
    val id: Long?,
    val name: String,
    val phone: String,
    val email: String,
    val deleted: Boolean,
)