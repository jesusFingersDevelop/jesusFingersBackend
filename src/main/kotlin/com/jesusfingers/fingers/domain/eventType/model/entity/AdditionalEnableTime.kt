package com.jesusfingers.fingers.domain.eventType.model.entity

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import javax.persistence.*

@Entity
data class AdditionalEnableTime(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var date: LocalDate,

    @Column(nullable = false)
    var startTime: LocalTime,

    @Column(nullable = false)
    var endTime: LocalTime,
)
