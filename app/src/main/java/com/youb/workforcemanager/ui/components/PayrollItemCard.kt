package com.youb.workforcemanager.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Pending
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.youb.workforcemanager.R
import com.youb.workforcemanager.model.PayrollItem
import java.text.NumberFormat
import java.util.*

@Composable
fun PayrollItemCard(
    item: PayrollItem,
    modifier: Modifier = Modifier
) {
    val currencyFormat = remember { NumberFormat.getCurrencyInstance(Locale.getDefault()) }
    
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
                    text = item.workerName,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                
                when (item.status) {
                    PayrollItem.Status.PENDING -> {
                        Icon(
                            imageVector = Icons.Default.Pending,
                            contentDescription = stringResource(R.string.pending),
                            tint = MaterialTheme.colorScheme.tertiary
                        )
                    }
                    PayrollItem.Status.APPROVED -> {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = stringResource(R.string.approved),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    PayrollItem.Status.PAID -> {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = stringResource(R.string.paid),
                            tint = MaterialTheme.colorScheme.secondary
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Salary breakdown
            SalaryRow(
                label = stringResource(R.string.base_salary),
                amount = item.baseSalary,
                currencyFormat = currencyFormat
            )
            SalaryRow(
                label = stringResource(R.string.overtime),
                amount = item.overtimePay,
                currencyFormat = currencyFormat
            )
            SalaryRow(
                label = stringResource(R.string.bonuses),
                amount = item.bonuses,
                currencyFormat = currencyFormat
            )
            SalaryRow(
                label = stringResource(R.string.deductions),
                amount = -item.deductions,
                currencyFormat = currencyFormat,
                isNegative = true
            )

            Divider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 1.dp
            )

            // Net salary
            SalaryRow(
                label = stringResource(R.string.net_salary),
                amount = item.netSalary,
                currencyFormat = currencyFormat,
                isTotal = true
            )
        }
    }
}

@Composable
private fun SalaryRow(
    label: String,
    amount: Double,
    currencyFormat: NumberFormat,
    isNegative: Boolean = false,
    isTotal: Boolean = false
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = if (isTotal) MaterialTheme.typography.bodyLarge else MaterialTheme.typography.bodyMedium,
            fontWeight = if (isTotal) FontWeight.Bold else FontWeight.Normal
        )
        Text(
            text = if (isNegative) "-${currencyFormat.format(amount)}" 
                  else currencyFormat.format(amount),
            style = if (isTotal) MaterialTheme.typography.bodyLarge else MaterialTheme.typography.bodyMedium,
            fontWeight = if (isTotal) FontWeight.Bold else FontWeight.Normal,
            color = when {
                isNegative -> MaterialTheme.colorScheme.error
                isTotal -> MaterialTheme.colorScheme.primary
                else -> MaterialTheme.colorScheme.onSurfaceVariant
            }
        )
    }
}