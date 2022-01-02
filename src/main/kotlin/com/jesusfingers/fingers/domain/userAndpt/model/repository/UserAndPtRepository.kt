package com.jesusfingers.fingers.domain.userAndpt.model.repository

import com.jesusfingers.fingers.domain.userAndpt.model.entity.UserAndPt
import org.springframework.data.jpa.repository.JpaRepository

interface UserAndPtRepository: JpaRepository<UserAndPt, Long> {
    fun findByUser(userId: Long): UserAndPt
    fun getAllByPtId(ptId: Long): List<UserAndPt>
}