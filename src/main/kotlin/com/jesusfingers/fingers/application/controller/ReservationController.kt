package com.jesusfingers.fingers.application.controller

import com.jesusfingers.fingers.application.request.ChangeReservationConfirmStateRequest
import com.jesusfingers.fingers.application.request.CreateReservationRequest
import com.jesusfingers.fingers.domain.reservation.service.ReservationService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/v1/reservation")
class ReservationController(private val reservationService: ReservationService) {

    @PostMapping
    fun createReservation(@RequestBody createReservationRequest: CreateReservationRequest) {
        reservationService.createReservation(
            createReservationRequest.userId,
            createReservationRequest.ptId,
            createReservationRequest.eventTypeId,
            createReservationRequest.startTime
        )
    }

    @GetMapping("/{reservationId}")
    fun getReservation(@PathVariable reservationId: Long) {}

    @PutMapping("/{reservationId}")
    fun changeReservationConfirmState(@PathVariable reservationId: Long, changeReservationConfirmStateRequest: ChangeReservationConfirmStateRequest) {
        val reservation = reservationService.getReservation(reservationId)

        reservation.changeConfirmState(changeReservationConfirmStateRequest.state)
    }

    @DeleteMapping("/{reservationId}")
    fun cancelReservation(@PathVariable reservationId: Long) {}
}