package com.jesusfingers.fingers.domain.users.model.repository

import com.jesusfingers.fingers.domain.users.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {

}