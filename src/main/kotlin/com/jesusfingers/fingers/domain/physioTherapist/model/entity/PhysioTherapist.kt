package com.jesusfingers.fingers.domain.physioTherapist.model.entity

import com.jesusfingers.fingers.domain.common.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "physio_therapists")
data class PhysioTherapist(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var name: String? = null,

    var email: String? = null,

    var password: String? = null,

    var deleted: Boolean = false,
): BaseTimeEntity()
