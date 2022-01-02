package com.jesusfingers.fingers.domain.user.service

import com.jesusfingers.fingers.domain.mock.UserServiceBase
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.any
import org.springframework.data.repository.findByIdOrNull


class UpdateUserTest: UserServiceBase() {

    @Test
    fun updateUserInfoSuccess() {
        val testId: Long = 10
        val updatedUserName = "update name"
        val userPhone = "010-0000-0000"
        val userEmail = "test@test.ts"
        val userDeletedState = false

        given(userRepository.findByIdOrNull(any()))
            .willReturn(null)

        val result = assertDoesNotThrow { userService.updateUserInfo(testId, updatedUserName, userPhone, userEmail) }

        Assertions.assertNotNull(result)
        Assertions.assertTrue(result.name == updatedUserName)
        Assertions.assertTrue(result.email == userEmail)
        Assertions.assertTrue(result.phone == userPhone)
        Assertions.assertTrue(result.deleted == userDeletedState)
    }

    @Test
    fun updateUserPasswordSuccess() {
        val testId: Long = 10
        val updatedUserName = "update name"
        val userPhone = "010-0000-0000"
        val userEmail = "test@test.ts"
        val updatedUserPassword = "update password"
        val userDeletedState = false

        given(userRepository.findByIdOrNull(any()))
            .willReturn(null)

        val result = assertDoesNotThrow { userService.updateUserPassword(testId, updatedUserPassword) }

        Assertions.assertNotNull(result)
        Assertions.assertTrue(result.name == updatedUserName)
        Assertions.assertTrue(result.email == userEmail)
        Assertions.assertTrue(result.phone == userPhone)
        Assertions.assertTrue(result.password == updatedUserPassword)
        Assertions.assertTrue(result.deleted == userDeletedState)
    }
}