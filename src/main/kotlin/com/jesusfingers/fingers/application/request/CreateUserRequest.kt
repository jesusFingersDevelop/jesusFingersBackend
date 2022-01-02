package com.jesusfingers.fingers.application.request

import javax.validation.constraints.NotNull

class CreateUserRequest(

    @field: NotNull
    val name: String,

    @field: NotNull
    val phone: String,

    @field: NotNull
    val email: String,

    @field: NotNull
    val password: String,
)