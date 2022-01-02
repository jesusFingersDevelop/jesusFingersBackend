package com.jesusfingers.fingers.domain.physioTherapist.service

import com.jesusfingers.fingers.domain.physioTherapist.exception.PtNotFoundException
import com.jesusfingers.fingers.domain.physioTherapist.model.dto.PtInfoDto
import com.jesusfingers.fingers.domain.physioTherapist.model.entity.PhysioTherapist
import com.jesusfingers.fingers.domain.physioTherapist.model.repository.PhysioTherapistRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalTime

@Service
class PhysioTherapistService(
    private val physioTherapistRepository: PhysioTherapistRepository
) {

    @Transactional
    fun createPt(
        name: String,
        phone: String,
        email: String,
        password: String,
        address: String,
    ): PtInfoDto {
        val pt = PhysioTherapist(
            name = name,
            phone = phone,
            email = email,
            password = password,
            address = address,
            workException = "",
        )
        return PtInfoDto(
            pt.name,
            pt.phone,
            pt.email,
            pt.deleted,
            pt.address,
            pt.workStartTime,
            pt.workEndTime,
            pt.workException,
        )
    }

    @Transactional
    fun getPt(ptId: Long): PhysioTherapist {
        return physioTherapistRepository.findByIdOrNull(ptId) ?: throw PtNotFoundException()
    }

    @Transactional
    fun updatePtEventTime(ptId: Long, startTime: LocalTime, endTime: LocalTime) {
        val pt = physioTherapistRepository.findByIdOrNull(ptId) ?: throw PtNotFoundException()

        pt.updateEventTime(startTime, endTime)
    }

    fun confirmUser(userId: Long, ptId: Long) {

    }

}