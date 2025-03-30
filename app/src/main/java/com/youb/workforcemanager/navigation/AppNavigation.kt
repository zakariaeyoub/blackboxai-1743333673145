package com.youb.workforcemanager.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.youb.workforcemanager.ui.screens.dashboard.DashboardScreen
import com.youb.workforcemanager.ui.screens.login.LoginScreen
import com.youb.workforcemanager.ui.screens.workers.WorkersScreen
import com.youb.workforcemanager.ui.screens.attendance.AttendanceScreen
import com.youb.workforcemanager.ui.screens.payroll.PayrollScreen
import com.youb.workforcemanager.ui.screens.settings.SettingsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(route = Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(route = Screen.Dashboard.route) {
            DashboardScreen(navController)
        }
        composable(route = Screen.Workers.route) {
            WorkersScreen(navController)
        }
        composable(route = Screen.Attendance.route) {
            AttendanceScreen(navController)
        }
        composable(route = Screen.Payroll.route) {
            PayrollScreen(navController)
        }
        composable(route = Screen.Settings.route) {
            SettingsScreen(navController)
        }
    }
}

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Dashboard : Screen("dashboard")
    object Workers : Screen("workers")
    object Attendance : Screen("attendance")
    object Payroll : Screen("payroll")
    object Settings : Screen("settings")
}