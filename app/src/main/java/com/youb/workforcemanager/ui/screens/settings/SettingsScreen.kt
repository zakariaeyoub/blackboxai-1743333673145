package com.youb.workforcemanager.ui.screens.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.youb.workforcemanager.R
import com.youb.workforcemanager.ui.components.SettingsItem
import com.youb.workforcemanager.ui.components.WorkforceAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            WorkforceAppBar(
                title = stringResource(R.string.settings),
                navigationIcon = Icons.Default.ArrowBack,
                onNavigationClick = { navController.popBackStack() }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            // Profile Section
            Text(
                text = stringResource(R.string.profile),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp)
            )
            SettingsItem(
                icon = Icons.Default.Person,
                title = stringResource(R.string.edit_profile),
                onClick = { /* TODO: Navigate to profile edit */ }
            )
            SettingsItem(
                icon = Icons.Default.Security,
                title = stringResource(R.string.change_password),
                onClick = { /* TODO: Navigate to password change */ }
            )

            // App Preferences Section
            Text(
                text = stringResource(R.string.app_preferences),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp)
            )
            SettingsItem(
                icon = Icons.Default.Language,
                title = stringResource(R.string.language),
                onClick = { /* TODO: Show language dialog */ }
            )
            SettingsItem(
                icon = Icons.Default.Notifications,
                title = stringResource(R.string.notifications),
                onClick = { /* TODO: Navigate to notifications */ }
            )

            // Account Section
            Text(
                text = stringResource(R.string.account),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp)
            )
            SettingsItem(
                icon = Icons.Default.ExitToApp,
                title = stringResource(R.string.logout),
                onClick = { /* TODO: Handle logout */ },
                isDestructive = true
            )
        }
    }
}