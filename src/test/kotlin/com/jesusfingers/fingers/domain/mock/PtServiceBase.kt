package com.jesusfingers.fingers.domain.mock

import com.jesusfingers.fingers.domain.physioTherapist.model.repository.PhysioTherapistRepository
import com.jesusfingers.fingers.domain.physioTherapist.service.PhysioTherapistService
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
open class PtServiceBase {

    @Mock
    lateinit var physioTherapistRepository: PhysioTherapistRepository

    @InjectMocks
    lateinit var physioTherapistService: PhysioTherapistService
}