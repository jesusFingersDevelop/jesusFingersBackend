package com.jesusfingers.fingers.domain.reservation.model.repository

import com.jesusfingers.fingers.domain.reservation.model.entity.Reservation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReservationRepository: JpaRepository<Reservation, Long> {
}