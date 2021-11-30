package com.jesusfingers.fingers.domain.mock

import com.jesusfingers.fingers.domain.user.model.repository.UserRepository
import com.jesusfingers.fingers.domain.user.service.UserService
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
open class UserServiceBase {

    @Mock
    lateinit var userRepository: UserRepository

    @InjectMocks
    lateinit var userService: UserService
}