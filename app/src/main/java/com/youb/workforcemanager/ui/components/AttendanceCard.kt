package com.youb.workforcemanager.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.youb.workforcemanager.R
import com.youb.workforcemanager.model.AttendanceRecord

@Composable
fun AttendanceCard(
    record: AttendanceRecord,
    onCheckIn: () -> Unit,
    onCheckOut: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = record.workerName,
                    style = MaterialTheme.typography.bodyLarge
                )
                when (record.status) {
                    AttendanceRecord.Status.PRESENT -> {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = stringResource(R.string.check_in),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    AttendanceRecord.Status.ABSENT -> {
                        Text(
                            text = stringResource(R.string.absent),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                    else -> {
                        // Handle other statuses if needed
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.check_in) + ": ${record.checkIn ?: "N/A"}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = stringResource(R.string.check_out) + ": ${record.checkOut ?: "N/A"}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onCheckIn,
                modifier = Modifier.fillMaxWidth(),
                enabled = record.checkIn == null
            ) {
                Text(stringResource(R.string.check_in))
            }

            Spacer(modifier = Modifier.height(4.dp))

            Button(
                onClick = onCheckOut,
                modifier = Modifier.fillMaxWidth(),
                enabled = record.checkOut == null
            ) {
                Text(stringResource(R.string.check_out))
            }
        }
    }
}