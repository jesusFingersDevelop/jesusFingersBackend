package com.jesusfingers.fingers.domain.eventType.model.repository

import com.jesusfingers.fingers.domain.eventType.model.entity.EventType
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.Id

interface EventTypeRepository: JpaRepository<EventType, Long> {
    fun findAllById(ptId: Long): List<EventType>
}