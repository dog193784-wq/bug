package com.carelink.app.data.provider

import android.content.Context
import com.carelink.app.domain.model.HealthData
import com.carelink.app.domain.model.HealthMetric
import javax.inject.Inject

class GoogleFitProvider @Inject constructor(private val context: Context) : HealthDataProvider {
    override suspend fun fetch(parentId: String, metrics: Set<HealthMetric>, startTimeMillis: Long, endTimeMillis: Long): List<HealthData> {
        return metrics.map { HealthData(parentId, it, 0.0, "n/a", endTimeMillis, "google_fit_stub") }
    }
}
