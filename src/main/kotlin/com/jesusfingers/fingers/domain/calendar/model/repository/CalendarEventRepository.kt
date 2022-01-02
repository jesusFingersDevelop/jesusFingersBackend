package com.jesusfingers.fingers.domain.calendar.model.repository

import com.jesusfingers.fingers.domain.calendar.model.entity.CalendarEvent
import org.springframework.data.jpa.repository.JpaRepository

interface CalendarEventRepository: JpaRepository<CalendarEvent, Long> {
}