package com.jesusfingers.fingers.domain.eventType.service

import com.jesusfingers.fingers.domain.physioTherapist.exception.EventTypeNotFoundException
import com.jesusfingers.fingers.domain.physioTherapist.exception.PtNotFoundException
import com.jesusfingers.fingers.domain.eventType.model.dto.EventTypeInfoDto
import com.jesusfingers.fingers.domain.eventType.model.entity.EventType
import com.jesusfingers.fingers.domain.eventType.model.repository.EventTypeRepository
import com.jesusfingers.fingers.domain.physioTherapist.model.repository.PhysioTherapistRepository
import jdk.management.jfr.EventTypeInfo
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EventTypeService(
    private val eventTypeRepository: EventTypeRepository,
    private val physioTherapistRepository: PhysioTherapistRepository

) {

    @Transactional
    fun createEvent(ptId: Long, title: String, eventType: String, description: String): EventTypeInfoDto {
        val pt = physioTherapistRepository.findByIdOrNull(ptId) ?: throw PtNotFoundException()

        val eventType = EventType(
            title = title,
            eventType = eventType,
            pt_id = pt,
            description = description
        )

        eventTypeRepository.save(eventType)

        return EventTypeInfoDto(
            eventType.title,
            eventType.eventType,
            eventType.timeType,
            eventType.description
        )
    }

    @Transactional
    fun getEventList(ptId: Long): List<EventTypeInfoDto> {
        val tempEventList = eventTypeRepository.findAllById(ptId)
        var eventList = mutableListOf<EventTypeInfoDto>()

        if (tempEventList.isEmpty()) return eventList

        for (event: EventType in tempEventList) {
            eventList.add(
                EventTypeInfoDto(
                    event.title,
                    event.description,
                    event.timeType,
                    event.eventType,
                )
            )
        }

        return eventList
    }

    @Transactional
    fun getEvent(eventId: Long): EventTypeInfoDto {
        val event = eventTypeRepository.findByIdOrNull(eventId) ?: throw EventTypeNotFoundException()

        return EventTypeInfoDto(
            event.title,
            event.description,
            event.timeType,
            event.eventType,
        )
    }

    fun changeTimeType() {}

    fun addEnableTime() {}
    fun getEnableTimeList() {}
    fun updateEnableTime() {}
    fun deleteEnableTime() {}
}