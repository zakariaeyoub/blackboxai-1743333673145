package com.youb.workforcemanager.ui.screens.payroll

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.youb.workforcemanager.R
import com.youb.workforcemanager.model.PayrollItem
import com.youb.workforcemanager.ui.components.PayrollItemCard
import com.youb.workforcemanager.ui.components.WorkforceAppBar
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PayrollScreen(navController: NavController) {
    val currentMonth = remember { SimpleDateFormat("MMMM yyyy", Locale.getDefault()).format(Date()) }
    var selectedMonth by remember { mutableStateOf(currentMonth) }
    
    val payrollItems = listOf(
        PayrollItem(
            workerId = "001",
            workerName = "Ahmed Mohammed",
            baseSalary = 5000.0,
            overtimePay = 1250.0,
            deductions = 250.0,
            bonuses = 500.0,
            netSalary = 6500.0,
            status = PayrollItem.Status.PENDING
        ),
        PayrollItem(
            workerId = "002",
            workerName = "Youssef Ali",
            baseSalary = 4500.0,
            overtimePay = 900.0,
            deductions = 150.0,
            bonuses = 300.0,
            netSalary = 5550.0,
            status = PayrollItem.Status.APPROVED
        )
    )

    Scaffold(
        topBar = {
            WorkforceAppBar(
                title = stringResource(R.string.payroll),
                navigationIcon = Icons.Default.ArrowBack,
                onNavigationClick = { navController.popBackStack() }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { /* TODO: Process payroll */ },
                icon = { Icon(Icons.Default.AttachMoney, contentDescription = null) },
                text = { Text(stringResource(R.string.process_payroll)) }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            // Month selector
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = selectedMonth,
                    style = MaterialTheme.typography.titleMedium
                )
                IconButton(onClick = { /* TODO: Show month picker */ }) {
                    Icon(
                        imageVector = Icons.Default.CalendarMonth,
                        contentDescription = stringResource(R.string.select_month)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Payroll items list
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(payrollItems) { item ->
                    PayrollItemCard(item = item)
                }
            }
        }
    }
}