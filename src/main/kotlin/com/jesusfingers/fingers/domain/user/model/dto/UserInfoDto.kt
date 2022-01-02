package com.jesusfingers.fingers.domain.user.model.dto

data class UserInfoDto(
    val userId: Long?,
    val name: String,
    val phone: String,
    val email: String,
    val deleted: Boolean,
)
