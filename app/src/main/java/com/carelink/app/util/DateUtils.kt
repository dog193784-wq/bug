package com.carelink.app.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtils {
    fun formatDate(timestamp: Long): String = SimpleDateFormat("dd/MM/yyyy", Locale.US).format(Date(timestamp))
}
