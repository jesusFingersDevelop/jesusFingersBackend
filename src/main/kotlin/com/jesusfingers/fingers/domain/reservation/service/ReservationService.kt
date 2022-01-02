package com.jesusfingers.fingers.domain.reservation.service

import com.jesusfingers.fingers.domain.eventType.model.repository.EventTypeRepository
import com.jesusfingers.fingers.domain.physioTherapist.exception.PtNotFoundException
import com.jesusfingers.fingers.domain.physioTherapist.model.repository.PhysioTherapistRepository
import com.jesusfingers.fingers.domain.reservation.model.dto.CreateReservationDto
import com.jesusfingers.fingers.domain.reservation.model.dto.ReservationInfoDto
import com.jesusfingers.fingers.domain.reservation.model.entity.Reservation
import com.jesusfingers.fingers.domain.reservation.model.exception.ReservationNotFoundException
import com.jesusfingers.fingers.domain.reservation.model.repository.ReservationRepository
import com.jesusfingers.fingers.domain.user.exception.UserNotFoundException
import com.jesusfingers.fingers.domain.user.model.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@Service
class ReservationService(
    private val reservationRepository: ReservationRepository,
    private val eventTypeRepository: EventTypeRepository,
    private val userRepository: UserRepository,
    private val physioTherapistRepository: PhysioTherapistRepository
) {

    @Transactional
    fun createReservation(userId: Long, ptId: Long, eventTypeId: Long, startAt: LocalDateTime): ReservationInfoDto {
        val eventType = eventTypeRepository.findByIdOrNull(eventTypeId) ?: throw ReservationNotFoundException()
        val user = userRepository.findByIdOrNull(userId) ?: throw UserNotFoundException()
        val pt = physioTherapistRepository.findByIdOrNull(ptId) ?: throw PtNotFoundException()

        val newReservation = Reservation(
            isConfirmed = false,
            startAt = startAt,
            eventTypeId = eventType,
            userId = user,
            ptId = pt,
        )

        reservationRepository.save(newReservation)

        return ReservationInfoDto(
            startAt = newReservation.startAt,
            isConfirmed = newReservation.isConfirmed,
            eventTypeId = newReservation.eventTypeId,
            userId = newReservation.userId
        )
    }

    @Transactional
    fun getReservation(reservationId: Long): Reservation {
        return reservationRepository.findByIdOrNull(reservationId) ?: throw ReservationNotFoundException()
    }

    @Transactional
    fun getReservations(ptId: Long): List<ReservationInfoDto> {
        val reservations = reservationRepository.findReservationsByPtId(ptId)
        val reservationList = mutableListOf<ReservationInfoDto>()

        if (reservations.isEmpty()) return reservationList

        for (reservation: Reservation in reservations) {
            reservationList.add(
                ReservationInfoDto(
                    reservation.startAt,
                    reservation.isConfirmed,
                    reservation.eventTypeId,
                    reservation.userId,
                )
            )
        }

        return reservationList
    }

    @Transactional
    fun getNotConfirmedReservations(ptId: Long): List<ReservationInfoDto> {
        val reservations = reservationRepository.findReservationsByPtId(ptId)
        var notConfirmedReservations = mutableListOf<ReservationInfoDto>()

        if (reservations.isEmpty()) return notConfirmedReservations

        for (reservation: Reservation in reservations) {
            if (!reservation.isConfirmed) {
                notConfirmedReservations.add(
                    ReservationInfoDto(
                        reservation.startAt,
                        reservation.isConfirmed,
                        reservation.eventTypeId,
                        reservation.userId,
                    )
                )
            }
        }

        return notConfirmedReservations
    }

    @Transactional
    fun getConfirmedReservationsByDate(ptId: Long): List<ReservationInfoDto> {
        val date = LocalDate.now();
        val startDate = LocalDateTime.of(date, LocalTime.of(0, 0, 0))
        val endDate = LocalDateTime.of(date, LocalTime.of(23, 59, 59))

        val reservations = reservationRepository.findReservationsByPtIdAndStartAtBetween(ptId, startDate, endDate)
        var confirmedReservations = mutableListOf<ReservationInfoDto>()

        if (reservations.isEmpty()) return confirmedReservations

        for (reservation: Reservation in reservations) {
            if (reservation.isConfirmed) {
                confirmedReservations.add(
                    ReservationInfoDto(
                        reservation.startAt,
                        reservation.isConfirmed,
                        reservation.eventTypeId,
                        reservation.userId,
                    )
                )
            }
        }

        return confirmedReservations
    }

    @Transactional
    fun confirmReservation(reservationId: Long, state: Boolean) {
        val reservation = reservationRepository.findByIdOrNull(reservationId) ?: throw ReservationNotFoundException()

        reservation.changeConfirmState(state);
    }

    @Transactional
    fun deleteReservation(reservationId: Long) {
        val reservation = reservationRepository.findByIdOrNull(reservationId) ?: throw ReservationNotFoundException()

        reservation.deleteReservation()
    }
}