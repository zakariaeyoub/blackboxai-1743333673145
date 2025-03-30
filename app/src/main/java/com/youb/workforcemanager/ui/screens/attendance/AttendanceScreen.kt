package com.youb.workforcemanager.ui.screens.attendance

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.youb.workforcemanager.R
import com.youb.workforcemanager.model.AttendanceRecord
import com.youb.workforcemanager.ui.components.AttendanceCard
import com.youb.workforcemanager.ui.components.WorkforceAppBar
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceScreen(navController: NavController) {
    val currentDate = remember { SimpleDateFormat("EEEE, MMMM d", Locale.getDefault()).format(Date()) }
    var selectedDate by remember { mutableStateOf(currentDate) }
    
    val attendanceRecords = listOf(
        AttendanceRecord(
            workerId = "001",
            workerName = "Ahmed Mohammed",
            checkIn = "08:00 AM",
            checkOut = "05:30 PM",
            status = AttendanceRecord.Status.PRESENT,
            overtime = "2.5"
        ),
        AttendanceRecord(
            workerId = "002", 
            workerName = "Youssef Ali",
            checkIn = "08:15 AM",
            checkOut = "06:00 PM",
            status = AttendanceRecord.Status.PRESENT,
            overtime = "3.0"
        ),
        AttendanceRecord(
            workerId = "003",
            workerName = "Mohammed Hassan",
            checkIn = null,
            checkOut = null,
            status = AttendanceRecord.Status.ABSENT,
            overtime = "0.0"
        )
    )

    Scaffold(
        topBar = {
            WorkforceAppBar(
                title = stringResource(R.string.attendance),
                navigationIcon = Icons.Default.ArrowBack,
                onNavigationClick = { navController.popBackStack() }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            // Date selector
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = selectedDate,
                    style = MaterialTheme.typography.titleMedium
                )
                IconButton(onClick = { /* TODO: Show date picker */ }) {
                    Icon(
                        imageVector = Icons.Default.CalendarToday,
                        contentDescription = stringResource(R.string.select_date)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Attendance list
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(attendanceRecords) { record ->
                    AttendanceCard(
                        record = record,
                        onCheckIn = { /* TODO: Handle check-in */ },
                        onCheckOut = { /* TODO: Handle check-out */ }
                    )
                }
            }
        }
    }
}