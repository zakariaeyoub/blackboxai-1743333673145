package com.youb.workforcemanager.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.youb.workforcemanager.R
import com.youb.workforcemanager.model.Activity
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun RecentActivityList() {
    val activities = listOf(
        Activity(
            workerName = "Ahmed Mohammed",
            site = "Dubai Marina Tower",
            type = Activity.Type.CHECK_IN,
            time = Date()
        ),
        Activity(
            workerName = "Youssef Ali",
            site = "Palm Jumeirah Villa",
            type = Activity.Type.OVERTIME,
            time = Date(System.currentTimeMillis() - 3600000)
        ),
        Activity(
            workerName = "Mohammed Hassan",
            site = "Downtown Office",
            type = Activity.Type.CHECK_OUT,
            time = Date(System.currentTimeMillis() - 7200000)
        ),
        Activity(
            workerName = "Karim Samir",
            site = "JBR Apartment",
            type = Activity.Type.ABSENCE,
            time = Date(System.currentTimeMillis() - 10800000)
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(activities) { activity ->
            ActivityItem(activity = activity)
        }
    }
}

@Composable
private fun ActivityItem(activity: Activity) {
    val (icon, color) = when (activity.type) {
        Activity.Type.CHECK_IN -> Icons.Default.CheckCircle to MaterialTheme.colorScheme.primary
        Activity.Type.CHECK_OUT -> Icons.Default.CheckCircle to MaterialTheme.colorScheme.secondary
        Activity.Type.OVERTIME -> Icons.Default.Schedule to MaterialTheme.colorScheme.tertiary
        Activity.Type.ABSENCE -> Icons.Default.Warning to MaterialTheme.colorScheme.error
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = color,
                modifier = Modifier.size(24.dp)
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = activity.workerName,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = activity.site,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Text(
                text = SimpleDateFormat("hh:mm a", Locale.getDefault()).format(activity.time),
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

data class Activity(
    val workerName: String,
    val site: String,
    val type: Type,
    val time: Date
) {
    enum class Type {
        CHECK_IN, CHECK_OUT, OVERTIME, ABSENCE
    }
}