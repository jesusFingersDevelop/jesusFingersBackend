package com.jesusfingers.fingers.domain.reservation.model.entity

import com.jesusfingers.fingers.domain.common.BaseTimeEntity
import com.jesusfingers.fingers.domain.eventType.model.entity.EventType
import com.jesusfingers.fingers.domain.physioTherapist.model.entity.PhysioTherapist
import com.jesusfingers.fingers.domain.user.model.entity.User
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "reservations")
data class Reservation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var isConfirmed: Boolean = false,

    @Column(nullable = false)
    var startAt: LocalDateTime,

    var deleted: Boolean = false,

    @ManyToOne
    @JoinColumn(name = "pt_id")
    val ptId: PhysioTherapist,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val userId: User,

    @ManyToOne
    @JoinColumn(name = "event_type_id")
    val eventTypeId: EventType,

): BaseTimeEntity() {
    fun changeConfirmState(state: Boolean) {
        this.isConfirmed = state
    }

    fun deleteReservation() {
        this.deleted = true
    }
}
