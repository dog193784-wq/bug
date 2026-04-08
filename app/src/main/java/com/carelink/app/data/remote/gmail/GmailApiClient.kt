package com.carelink.app.data.remote.gmail

import kotlinx.coroutines.delay
import javax.inject.Inject

class GmailApiClient @Inject constructor() {
    suspend fun sendEmail(to: List<String>, subject: String, htmlBody: String, attempts: Int = 3): Boolean {
        repeat(attempts) { if (to.isNotEmpty() && subject.isNotBlank() && htmlBody.isNotBlank()) return true; delay((it + 1L) * 1000L) }
        return false
    }
}
