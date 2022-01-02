package com.jesusfingers.fingers.domain.userAndpt.service

import com.jesusfingers.fingers.domain.physioTherapist.exception.PtNotFoundException
import com.jesusfingers.fingers.domain.physioTherapist.model.repository.PhysioTherapistRepository
import com.jesusfingers.fingers.domain.user.exception.UserNotFoundException
import com.jesusfingers.fingers.domain.user.model.repository.UserRepository
import com.jesusfingers.fingers.domain.userAndpt.model.entity.UserAndPt
import com.jesusfingers.fingers.domain.userAndpt.model.repository.UserAndPtRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserAndPtService(
    private val userAndPtRepository: UserAndPtRepository,
    private val userRepository: UserRepository,
    private val physioTherapistRepository: PhysioTherapistRepository,
) {

    @Transactional
    fun createMatchUserAndPt(userId: Long, ptId: Long) {
        val user = userRepository.findByIdOrNull(userId) ?: throw UserNotFoundException()
        val pt = physioTherapistRepository.findByIdOrNull(ptId) ?: throw PtNotFoundException()

        val match = UserAndPt(
            userId = user,
            ptId = pt,
        )

        userAndPtRepository.save(match)
    }

    @Transactional
    fun changeUserMatchStateToTure(userId: Long) {
        var match = userAndPtRepository.findByUser(userId)
        match.updateConfirmStateToTrue()
    }

    @Transactional
    fun changeUserMatchStateToFalse(userId: Long) {
        var match = userAndPtRepository.findByUser(userId)
        match.updateConfirmStateToFalse()
    }

    @Transactional
    fun getAllUser(ptId: Long) {
        val matchs = userAndPtRepository.getAllByPtId(ptId)
    }
}