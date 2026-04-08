package com.carelink.app.domain.repository

interface DeliveryRepository {
    suspend fun log(entry: com.carelink.app.domain.model.DeliveryLog)
}
