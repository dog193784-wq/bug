package com.carelink.app.data.repository

import com.carelink.app.data.local.db.dao.*
import com.carelink.app.data.local.db.entity.DeliveryLogEntity
import com.carelink.app.data.local.db.entity.HealthDataEntity
import com.carelink.app.domain.model.*
import com.carelink.app.domain.repository.*
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class HealthDataRepositoryImpl @Inject constructor(private val dao: HealthDataDao) : HealthDataRepository {
    override suspend fun insertAll(items: List<HealthData>) = dao.insertAll(items.map {
        HealthDataEntity(parentId = it.parentId, metricType = it.metricType.name, value = it.value, unit = it.unit, timestamp = it.timestamp, date = "1970-01-01", rawData = it.rawData)
    })
    override suspend fun getLatest(parentId: String): List<HealthData> = dao.latest(parentId).first().map { HealthData(it.parentId, HealthMetric.valueOf(it.metricType), it.value, it.unit, it.timestamp, it.rawData) }
}

class AlertRepositoryImpl @Inject constructor(private val dao: AlertRuleDao) : AlertRepository {
    override suspend fun getEnabled(parentId: String): List<AlertRule> = dao.enabled(parentId).map { AlertRule(parentId = it.parentId, alertType = AlertType.valueOf(it.alertType), metricType = HealthMetric.valueOf(it.metricType), condition = ThresholdCondition.valueOf(it.condition), thresholdValue = it.threshold) }
}

class ReportRepositoryImpl @Inject constructor(private val dao: ReportConfigDao) : ReportRepository {
    override suspend fun getConfigs(parentId: String): List<ReportConfig> = dao.enabled(parentId).map { ReportConfig(parentId = it.parentId, reportType = ReportType.valueOf(it.reportType), enabled = it.enabled, format = ReportFormat.valueOf(it.format), deliveryChannel = DeliveryChannel.valueOf(it.deliveryChannel), recipients = emptyList(), scheduledTime = it.scheduledTime) }
}

class DeliveryRepositoryImpl @Inject constructor(private val dao: DeliveryLogDao) : DeliveryRepository {
    override suspend fun log(entry: DeliveryLog) = dao.insert(DeliveryLogEntity(parentId = entry.parentId, type = entry.type, channel = entry.channel.name, status = entry.status, recipient = entry.recipient, sentAt = entry.sentAt, errorMessage = entry.errorMessage))
}
