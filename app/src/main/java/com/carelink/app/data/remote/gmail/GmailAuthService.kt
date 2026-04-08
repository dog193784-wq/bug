package com.carelink.app.data.remote.gmail

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import javax.inject.Inject

class GmailAuthService @Inject constructor(context: Context) {
    private val prefs = EncryptedSharedPreferences.create(
        context,
        "gmail_auth",
        MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(),
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
    )
    fun saveToken(token: String) { prefs.edit().putString("oauth_token", token).apply() }
    fun getToken(): String? = prefs.getString("oauth_token", null)
}
