package com.carelink.app.di

import com.carelink.app.data.repository.AlertRepositoryImpl
import com.carelink.app.data.repository.DeliveryRepositoryImpl
import com.carelink.app.data.repository.HealthDataRepositoryImpl
import com.carelink.app.data.repository.ReportRepositoryImpl
import com.carelink.app.domain.repository.AlertRepository
import com.carelink.app.domain.repository.DeliveryRepository
import com.carelink.app.domain.repository.HealthDataRepository
import com.carelink.app.domain.repository.ReportRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides fun healthRepo(impl: HealthDataRepositoryImpl): HealthDataRepository = impl
    @Provides fun alertRepo(impl: AlertRepositoryImpl): AlertRepository = impl
    @Provides fun reportRepo(impl: ReportRepositoryImpl): ReportRepository = impl
    @Provides fun deliveryRepo(impl: DeliveryRepositoryImpl): DeliveryRepository = impl
}
