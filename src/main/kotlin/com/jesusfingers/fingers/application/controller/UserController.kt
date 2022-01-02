package com.jesusfingers.fingers.application.controller

import com.jesusfingers.fingers.application.request.CreateUserRequest
import com.jesusfingers.fingers.application.response.CreateUserResponse
import com.jesusfingers.fingers.application.response.GetUserResponse
import com.jesusfingers.fingers.domain.user.service.UserService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/user")
class UserController(private val userService: UserService) {

    @PostMapping
    fun createUser(@Valid @RequestBody createUserRequest: CreateUserRequest): CreateUserResponse {
        val user = userService.createUser(
            createUserRequest.name,
            createUserRequest.phone,
            createUserRequest.email,
            createUserRequest.password
        )

        return CreateUserResponse(
            user.userId,
            user.name,
            user.phone,
            user.email,
            user.deleted
        )
    }

    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: Long): GetUserResponse {
        val user = userService.getUser(userId)
        return GetUserResponse(user.name, user.phone, user.email, user.deleted)
    }

    @PutMapping("/{userId}")
    fun updateUserInfo(@PathVariable userId: Long) {
        val user = userService.getUser(userId)
    }

    @PutMapping("/{userId}")
    fun updateUserPassword(@PathVariable userId: Long) {
        val user = userService.getUser(userId)
    }

    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId: Long) {
        userService.deleteUser(userId)
    }
}