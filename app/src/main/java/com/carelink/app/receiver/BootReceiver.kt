package com.carelink.app.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.work.*
import com.carelink.app.service.AlertEvaluationWorker
import com.carelink.app.service.HealthSyncWorker
import com.carelink.app.service.ReportSchedulerWorker
import java.util.concurrent.TimeUnit

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            val manager = WorkManager.getInstance(context)
            manager.enqueueUniquePeriodicWork("health_sync", ExistingPeriodicWorkPolicy.KEEP, PeriodicWorkRequestBuilder<HealthSyncWorker>(1, TimeUnit.HOURS).build())
            manager.enqueueUniquePeriodicWork("report_scheduler", ExistingPeriodicWorkPolicy.KEEP, PeriodicWorkRequestBuilder<ReportSchedulerWorker>(15, TimeUnit.MINUTES).build())
            manager.enqueueUniquePeriodicWork("alert_eval", ExistingPeriodicWorkPolicy.KEEP, PeriodicWorkRequestBuilder<AlertEvaluationWorker>(15, TimeUnit.MINUTES).build())
        }
    }
}
