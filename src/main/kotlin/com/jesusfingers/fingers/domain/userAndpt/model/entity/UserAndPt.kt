package com.jesusfingers.fingers.domain.userAndpt.model.entity

import com.jesusfingers.fingers.domain.common.BaseTimeEntity
import com.jesusfingers.fingers.domain.physioTherapist.model.entity.PhysioTherapist
import com.jesusfingers.fingers.domain.user.model.entity.User
import javax.persistence.*

@Entity
data class UserAndPt(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val userId: User? = null,

    @ManyToOne
    @JoinColumn(name = "pt_id")
    val ptId: PhysioTherapist? = null,

    var isConfirm: Boolean = false
): BaseTimeEntity() {
    fun updateConfirmStateToTrue() {
        this.isConfirm = true
    }
    fun updateConfirmStateToFalse() {
        this.isConfirm = false
    }
}