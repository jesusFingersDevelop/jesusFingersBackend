package com.jesusfingers.fingers.domain.user.model.repository

import com.jesusfingers.fingers.domain.user.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {

}