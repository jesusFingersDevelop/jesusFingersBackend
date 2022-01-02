package com.jesusfingers.fingers.application.response

data class GetUserResponse(
    val name: String,
    val phone: String,
    val email: String,
    val delete: Boolean,
)
