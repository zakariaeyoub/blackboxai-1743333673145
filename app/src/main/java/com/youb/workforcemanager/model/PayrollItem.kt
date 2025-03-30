package com.youb.workforcemanager.model

data class PayrollItem(
    val workerId: String,
    val workerName: String,
    val baseSalary: Double,
    val overtimePay: Double,
    val deductions: Double,
    val bonuses: Double,
    val netSalary: Double,
    val status: Status
) {
    enum class Status {
        PENDING, APPROVED, PAID
    }
}