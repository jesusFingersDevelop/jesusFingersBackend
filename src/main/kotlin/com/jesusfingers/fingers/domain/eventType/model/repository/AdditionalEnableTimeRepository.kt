package com.jesusfingers.fingers.domain.eventType.model.repository

import com.jesusfingers.fingers.domain.eventType.model.entity.AdditionalEnableTime
import org.springframework.data.jpa.repository.JpaRepository

interface AdditionalEnableTimeRepository: JpaRepository<AdditionalEnableTime, Long> {
}