package com.jesusfingers.fingers.domain.user.service

import com.jesusfingers.fingers.domain.mock.UserServiceBase
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.any

class DeleteUserTest: UserServiceBase() {

    @Test
    fun deleteUserSuccess() {
        val testId: Long = 10
        val userName = "name"
        val userPhone = "010-0000-0000"
        val userEmail = "test@test.ts"
        val userPassword = "password"
        val userDeletedState = false

        given(userRepository.findAllById(any()))
            .willReturn(null)

        val result = assertDoesNotThrow { userService.deleteUser(testId) }

        Assertions.assertNotNull(result)
    }
}