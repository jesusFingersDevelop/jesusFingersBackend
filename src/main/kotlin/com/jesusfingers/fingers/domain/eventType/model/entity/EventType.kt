package com.jesusfingers.fingers.domain.eventType.model.entity

import com.jesusfingers.fingers.domain.common.BaseTimeEntity
import com.jesusfingers.fingers.domain.eventType.model.dto.EventTypeInfoDto
import com.jesusfingers.fingers.domain.physioTherapist.model.entity.PhysioTherapist
import javax.persistence.*

@Entity
@Table(name = "event_types")
data class EventType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var title: String,

    @Column(nullable = false)
    var eventType: String,

    var description: String,

    var timeType: Boolean = false,

    @ManyToOne
    @JoinColumn(name = "pt_id")
    val pt_id: PhysioTherapist,

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "enable_time_id")
    var enableTime: MutableList<AdditionalEnableTime>? = null,

): BaseTimeEntity() {
    fun addEnableTime(enableTime: AdditionalEnableTime) {}
    fun update(eventTypeInfoDto: EventTypeInfoDto) {
        this.eventType = eventTypeInfoDto.eventType
        this.timeType = eventTypeInfoDto.timeType
        this.title = eventTypeInfoDto.title
        this.description = eventTypeInfoDto.description
    }
}
