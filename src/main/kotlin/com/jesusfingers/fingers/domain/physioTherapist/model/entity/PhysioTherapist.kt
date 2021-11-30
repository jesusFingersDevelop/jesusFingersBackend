package com.jesusfingers.fingers.domain.physioTherapist.model.entity

import com.jesusfingers.fingers.domain.common.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "physio_therapists")
data class PhysioTherapist(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

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

    var isConfirmed: Boolean = false,

    var deleted: Boolean = false

): BaseTimeEntity()
