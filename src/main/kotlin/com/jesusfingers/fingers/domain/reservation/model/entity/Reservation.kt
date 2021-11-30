package com.jesusfingers.fingers.domain.reservation.model.entity

import com.jesusfingers.fingers.domain.common.BaseTimeEntity
import com.jesusfingers.fingers.domain.physioTherapist.model.entity.PhysioTherapist
import com.jesusfingers.fingers.domain.users.model.entity.User
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "reservations")
data class Reservation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    var isConfirmed: Boolean = false,

    @Column(nullable = false)
    var startAt: LocalDateTime? = null,

    @Column(nullable = false)
    var eventType: String? = null,

    var deleted: Boolean = false,

    @ManyToOne
    @JoinColumn(name = "pt_id")
    val pt: PhysioTherapist,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User

): BaseTimeEntity()
