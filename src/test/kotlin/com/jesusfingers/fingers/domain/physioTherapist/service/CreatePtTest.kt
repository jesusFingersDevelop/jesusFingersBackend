package com.jesusfingers.fingers.domain.physioTherapist.service

import com.jesusfingers.fingers.domain.mock.PtServiceBase
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.any

class CreatePtTest: PtServiceBase() {

    @Test
    fun createPtSuccess() {
        val ptName = "pt name"
        val ptPhone = "010-0000-0000"
        val ptEmail = "test@test.ts"
        val ptPassword = "password"
        val ptAddress = "address"

//        given(physioTherapistRepository.save(any()))
//            .willReturn(null)

        val result = assertDoesNotThrow { physioTherapistService.createPt(ptName, ptPhone, ptEmail, ptPassword, ptAddress) }

        assertNotNull(result)
        assertTrue(result.name == ptName)
        assertTrue(result.email == ptEmail)
        assertTrue(result.phone == ptPhone)
        assertTrue(result.address == ptAddress)
        assertTrue(!result.deleted)
    }
}