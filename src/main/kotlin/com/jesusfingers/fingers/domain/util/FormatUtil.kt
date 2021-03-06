package com.jesusfingers.fingers.domain.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object FormatUtil {
    private const val localDateTimeToStringPattern: String = "yyyy-MM-dd HH:mm:ss"

    fun localDateTimeToString(localDateTime: LocalDateTime?): String {
        return localDateTime!!.format(DateTimeFormatter.ofPattern(localDateTimeToStringPattern))
    }
}