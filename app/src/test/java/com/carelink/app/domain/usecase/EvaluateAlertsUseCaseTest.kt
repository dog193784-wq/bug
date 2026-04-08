package com.carelink.app.domain.usecase

import com.carelink.app.domain.model.*
import com.carelink.app.util.ResultState
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class EvaluateAlertsUseCaseTest {
    private val useCase = EvaluateAlertsUseCase()

    @Test
    fun `returns triggered rule when threshold exceeded`() {
        val data = listOf(HealthData("p1", HealthMetric.HEART_RATE, 105.0, "BPM", 1L))
        val rules = listOf(
            AlertRule(parentId = "p1", alertType = AlertType.HEART_RATE_HIGH, metricType = HealthMetric.HEART_RATE, condition = ThresholdCondition.ABOVE, thresholdValue = 100.0)
        )

        val result = useCase(data, rules)
        assertTrue(result is ResultState.Success)
        assertEquals(1, (result as ResultState.Success).data.size)
    }
}
