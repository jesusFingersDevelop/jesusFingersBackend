package com.jesusfingers.fingers.domain.calendar.model.entity

import com.jesusfingers.fingers.domain.common.BaseTimeEntity
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "calenar_events")
data class CalendarEvent(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var title: String,

    @Column(nullable = false)
    var date: LocalDateTime,
): BaseTimeEntity()