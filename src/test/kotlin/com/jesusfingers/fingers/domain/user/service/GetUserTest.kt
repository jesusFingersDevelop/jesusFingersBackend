package com.jesusfingers.fingers.domain.user.service

import com.jesusfingers.fingers.domain.mock.UserServiceBase
import com.jesusfingers.fingers.domain.user.model.entity.User
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.any
import java.util.*

class GetUserTest: UserServiceBase() {

    @Test
    fun getUserSuccess() {
        val testId: Long = 10
        val userName = "name"
        val userPhone = "010-0000-0000"
        val userEmail = "test@test.ts"
        val userPassword = "password"
        val userDeletedState = false

        given(userRepository.findById(any()))
            .willReturn(Optional.of(User(testId, userName, userPhone, userEmail, userPassword)))

        val result = assertDoesNotThrow { userService.getUserInfo(testId) }

        Assertions.assertNotNull(result)
        Assertions.assertTrue(result.name == userName)
        Assertions.assertTrue(result.email == userEmail)
        Assertions.assertTrue(result.phone == userPhone)
        Assertions.assertTrue(result.deleted == userDeletedState)
    }
}