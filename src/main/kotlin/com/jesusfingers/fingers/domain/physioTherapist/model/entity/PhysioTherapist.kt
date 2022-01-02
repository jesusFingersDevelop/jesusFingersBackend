package com.jesusfingers.fingers.domain.physioTherapist.model.entity

import com.jesusfingers.fingers.domain.common.BaseTimeEntity
import java.sql.Time
import java.time.LocalTime
import javax.persistence.*

@Entity
@Table(name = "physio_therapists")
data class PhysioTherapist(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var phone: String,

    @Column(nullable = false)
    var email: String,

    @Column(nullable = false)
    var password: String,

    @Column(nullable = false)
    var address: String,

    @Column(nullable = false)
    var workStartTime: LocalTime = LocalTime.of(10,0, 0),

    @Column(nullable = false)
    var workEndTime: LocalTime = LocalTime.of(19,0, 0),

    var workException: String? = null,

    var isConfirmed: Boolean = false,

    var deleted: Boolean = false,

): BaseTimeEntity() {
    fun updateEventTime(startTime: LocalTime, endTime: LocalTime) {
        this.workStartTime = startTime
        this.workEndTime = endTime
    }
    fun updatePt() {}
}
