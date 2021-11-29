package com.jesusfingers.fingers.domain.users.model.entity

import com.jesusfingers.fingers.domain.common.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
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

    var deleted: Boolean = false,
): BaseTimeEntity()
