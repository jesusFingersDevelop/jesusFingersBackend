package com.jesusfingers.fingers.domain.mock

import com.jesusfingers.fingers.domain.eventType.model.repository.EventTypeRepository
import com.jesusfingers.fingers.domain.reservation.service.ReservationService
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
open class ReservationServiceBase {

    @Mock
    lateinit var reservationRepository: EventTypeRepository

    @InjectMocks
    lateinit var reservationService: ReservationService
}