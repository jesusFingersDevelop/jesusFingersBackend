package com.jesusfingers.fingers.application.controller

import com.jesusfingers.fingers.domain.physioTherapist.service.PhysioTherapistService
import com.jesusfingers.fingers.domain.reservation.service.ReservationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/waiting")
class WaitingUserController() {

    @GetMapping("/{ptId}")
    fun getWaitingUsers(@PathVariable ptId: Long) {}
    fun changeWaitingUserState() {}
}