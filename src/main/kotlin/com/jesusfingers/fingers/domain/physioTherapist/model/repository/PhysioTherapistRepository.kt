package com.jesusfingers.fingers.domain.physioTherapist.model.repository

import com.jesusfingers.fingers.domain.physioTherapist.model.entity.PhysioTherapist
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PhysioTherapistRepository: JpaRepository<PhysioTherapist, Long> {}