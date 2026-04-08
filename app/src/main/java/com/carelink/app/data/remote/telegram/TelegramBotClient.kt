package com.carelink.app.data.remote.telegram

import kotlinx.coroutines.delay
import javax.inject.Inject

class TelegramBotClient @Inject constructor() {
    suspend fun sendMessage(chatId: String, message: String): Boolean {
        val delays = listOf(1000L, 4000L, 16000L)
        repeat(3) { if (chatId.isNotBlank() && message.isNotBlank()) return true; delay(delays[it]) }
        return false
    }
}
