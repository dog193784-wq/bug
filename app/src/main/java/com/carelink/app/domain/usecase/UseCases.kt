package com.carelink.app.domain.usecase

import com.carelink.app.domain.model.*
import com.carelink.app.domain.repository.*
import com.carelink.app.util.ResultState
import javax.inject.Inject

class SyncHealthDataUseCase @Inject constructor(private val healthDataRepository: HealthDataRepository) {
    suspend operator fun invoke(records: List<HealthData>) = healthDataRepository.insertAll(records)
}

class GenerateReportUseCase @Inject constructor() {
    operator fun invoke(reportType: ReportType, items: List<HealthData>): String = "$reportType report with ${items.size} samples"
}

class SendReportUseCase @Inject constructor(private val deliveryRepository: DeliveryRepository) {
    suspend operator fun invoke(log: DeliveryLog) = deliveryRepository.log(log)
}

class EvaluateAlertsUseCase @Inject constructor() {
    operator fun invoke(latestMetrics: List<HealthData>, rules: List<AlertRule>): ResultState<List<AlertRule>> {
        val triggered = rules.filter { rule ->
            val value = latestMetrics.lastOrNull { it.metricType == rule.metricType }?.value ?: return@filter false
            when (rule.condition) {
                ThresholdCondition.ABOVE -> value > rule.thresholdValue
                ThresholdCondition.BELOW -> value < rule.thresholdValue
                ThresholdCondition.EQUALS -> value == rule.thresholdValue
                ThresholdCondition.OUTSIDE_RANGE -> value < rule.thresholdValue || value > (rule.secondaryThreshold ?: rule.thresholdValue)
            }
        }
        return ResultState.Success(triggered)
    }
}

class SendEmergencyAlertUseCase @Inject constructor(private val deliveryRepository: DeliveryRepository) {
    suspend operator fun invoke(parentId: String, recipient: String) = deliveryRepository.log(
        DeliveryLog(parentId, "ALERT", DeliveryChannel.BOTH, "PENDING", recipient, System.currentTimeMillis())
    )
}

class GetHealthHistoryUseCase @Inject constructor(private val healthDataRepository: HealthDataRepository) {
    suspend operator fun invoke(parentId: String): List<HealthData> = healthDataRepository.getLatest(parentId)
}
