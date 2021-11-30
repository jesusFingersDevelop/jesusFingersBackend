package com.jesusfingers.fingers.domain.user.model.entity

import com.jesusfingers.fingers.domain.common.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
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

    var deleted: Boolean = false,
): BaseTimeEntity() {
    fun updateUserInfo(name: String, phone: String, email: String) {
        this.name = name
        this.phone = phone
        this.email = email
    }
    fun updateUserPassword(password: String) {
        this.password = password
    }
    fun updateUserDeleted() {
        this.deleted = true
    }
}
