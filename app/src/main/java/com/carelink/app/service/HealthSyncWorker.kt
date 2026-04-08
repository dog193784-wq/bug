package com.carelink.app.service

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.carelink.app.data.local.preferences.UserPreferencesManager
import com.carelink.app.data.provider.ProviderFactory
import com.carelink.app.domain.usecase.SyncHealthDataUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.first

@HiltWorker
class HealthSyncWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val providerFactory: ProviderFactory,
    private val syncHealthDataUseCase: SyncHealthDataUseCase,
    private val prefs: UserPreferencesManager,
) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        val settings = prefs.settings.first()
        val records = providerFactory.primary().fetch("default-parent", settings.enabledMetrics, System.currentTimeMillis() - 3_600_000L, System.currentTimeMillis())
        syncHealthDataUseCase(records)
        return Result.success()
    }
}
