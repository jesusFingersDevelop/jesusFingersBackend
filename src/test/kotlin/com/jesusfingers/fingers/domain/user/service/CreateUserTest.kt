package com.jesusfingers.fingers.domain.user.service

import com.jesusfingers.fingers.domain.mock.UserServiceBase
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.any

class CreateUserTest: UserServiceBase() {

    @Test
    fun createUserSuccess() {
        val userName = "name"
        val userPhone = "010-0000-0000"
        val userEmail = "test@test.ts"
        val userPassword = "password"
        val userDeletedState = false

        given(userRepository.save(any()))
            .willReturn(null)

        val result = assertDoesNotThrow { userService.createUser(userName, userPhone, userEmail, userPassword) }

        assertNotNull(result)
        assertTrue(result.name == userName)
        assertTrue(result.email == userEmail)
        assertTrue(result.phone == userPhone)
        assertTrue(result.deleted == userDeletedState)
    }
}