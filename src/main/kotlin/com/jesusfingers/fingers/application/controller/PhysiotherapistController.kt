package com.jesusfingers.fingers.application.controller

import com.jesusfingers.fingers.application.request.CreatePtRequest
import com.jesusfingers.fingers.domain.physioTherapist.model.entity.PhysioTherapist
import com.jesusfingers.fingers.domain.physioTherapist.service.PhysioTherapistService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/pt")
class PhysiotherapistController(private val physioTherapistService: PhysioTherapistService) {

    @PostMapping
    fun createPt(@RequestBody createPtRequest: CreatePtRequest) {
        val pt = physioTherapistService.createPt(
            createPtRequest.name,
            createPtRequest.phone,
            createPtRequest.email,
            createPtRequest.password,
            createPtRequest.address,
        )
    }

    @PutMapping("/{ptId}")
    fun updatePtConfirmState(@PathVariable ptId: Long) {}

    @PutMapping("/{ptId}")
    fun updatePtInfo(@PathVariable ptId: Long) {}

    @GetMapping("/{ptId}")
    fun getPt(@PathVariable ptId: Long) {}

    @PutMapping("/{ptId}/time")
    fun updatePtWorkTime(@PathVariable ptId: Long) {}

    @GetMapping("/{ptId}/calendar")
    fun getPtCalendar(@PathVariable ptId: Long) {}

    @GetMapping("/{ptId}/event")
    fun getPtEvents(@PathVariable ptId: Long) {}

    @GetMapping("/{ptId}/reservation")
    fun getPtReservation(@PathVariable ptId: Long) {}

    @DeleteMapping("/{ptId}")
    fun deletePt(@PathVariable ptId: Long) {}
}