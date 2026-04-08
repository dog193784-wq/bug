package com.carelink.app.util

object EncryptionUtils {
    fun redacted(value: String): String = "***${value.takeLast(4)}"
}
