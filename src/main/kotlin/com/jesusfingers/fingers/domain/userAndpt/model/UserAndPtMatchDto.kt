package com.jesusfingers.fingers.domain.userAndpt.model

import com.jesusfingers.fingers.domain.physioTherapist.model.entity.PhysioTherapist
import com.jesusfingers.fingers.domain.user.model.entity.User

data class UserAndPtMatchDto(
    val user: User,
    val pt: PhysioTherapist,
    val state: Boolean,
)
