package com.carelink.app.data.provider

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProviderFactory @Inject constructor(private val googleFitProvider: GoogleFitProvider) {
    fun primary(): HealthDataProvider = googleFitProvider
}
