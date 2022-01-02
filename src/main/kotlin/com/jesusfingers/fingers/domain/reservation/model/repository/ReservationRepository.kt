package com.jesusfingers.fingers.domain.reservation.model.repository

import com.jesusfingers.fingers.domain.reservation.model.entity.Reservation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface ReservationRepository: JpaRepository<Reservation, Long> {
    fun findReservationsByPtId(ptId: Long): List<Reservation>
    fun findReservationsByPtIdAndStartAtBetween(ptId: Long, startDate: LocalDateTime, endDateTime: LocalDateTime): List<Reservation>
}