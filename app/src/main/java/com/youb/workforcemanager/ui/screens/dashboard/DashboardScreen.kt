package com.youb.workforcemanager.ui.screens.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.youb.workforcemanager.R
import com.youb.workforcemanager.ui.components.DashboardStats
import com.youb.workforcemanager.ui.components.RecentActivityList
import com.youb.workforcemanager.ui.components.WorkforceAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            NavigationDrawer(
                navController = navController,
                onDestinationClicked = { route ->
                    scope.launch { drawerState.close() }
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                WorkforceAppBar(
                    title = stringResource(R.string.dashboard),
                    navigationIcon = Icons.Default.Menu,
                    onNavigationClick = {
                        scope.launch { drawerState.open() }
                    }
                )
            },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
            ) {
                // Stats cards
                DashboardStats()

                Spacer(modifier = Modifier.height(24.dp))

                // Recent activity
                Text(
                    text = stringResource(R.string.recent_activity),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                RecentActivityList()
            }
        }
    )
}