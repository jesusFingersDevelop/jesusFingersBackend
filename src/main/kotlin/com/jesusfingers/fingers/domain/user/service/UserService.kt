package com.jesusfingers.fingers.domain.user.service

import com.jesusfingers.fingers.domain.user.exception.UserNotFoundException
import com.jesusfingers.fingers.domain.user.model.dto.UserInfoDto
import com.jesusfingers.fingers.domain.user.model.entity.User
import com.jesusfingers.fingers.domain.user.model.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    @Transactional
    fun createUser(name: String, phone: String, email: String, password: String): UserInfoDto {
        val user = User(
            name = name,
            phone = phone,
            email = email,
            password = password
        )

        userRepository.save(user)

        return UserInfoDto(user.id, user.name, user.phone, user.email, user.deleted)
    }

    @Transactional
    fun getUser(userId: Long): User {
        return userRepository.findByIdOrNull(userId) ?: throw UserNotFoundException()
    }

    @Transactional
    fun updateUserInfo(userId: Long, name: String, phone: String, email: String): User {
        val user = userRepository.findByIdOrNull(userId) ?: throw UserNotFoundException()
        user.updateUserInfo(name, phone, email)
        return user
    }

    @Transactional
    fun updateUserPassword(userId: Long, password: String): User {
        val user = userRepository.findByIdOrNull(userId) ?: throw UserNotFoundException()
        user.updateUserPassword(password)
        return user
    }

    @Transactional
    fun deleteUser(userId: Long) {
        val user = userRepository.findByIdOrNull(userId) ?: throw UserNotFoundException()
        user.updateUserDeleted()
    }
}