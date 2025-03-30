package com.youb.workforcemanager.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.youb.workforcemanager.R
import com.youb.workforcemanager.navigation.Screen

@Composable
fun NavigationDrawer(
    navController: NavController,
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        // Drawer Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_youb),
                    contentDescription = stringResource(R.string.app_name),
                    modifier = Modifier.size(80.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }

        // Drawer Items
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(drawerItems) { item ->
                NavigationDrawerItem(
                    icon = { Icon(item.icon, contentDescription = null) },
                    label = { Text(stringResource(item.label)) },
                    selected = navController.currentDestination?.route == item.route,
                    onClick = { onDestinationClicked(item.route) },
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
            }
        }

        // Language switcher in footer
        LanguageSwitcher(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

private val drawerItems = listOf(
    DrawerItem(
        icon = Icons.Default.Dashboard,
        label = R.string.dashboard,
        route = Screen.Dashboard.route
    ),
    DrawerItem(
        icon = Icons.Default.People,
        label = R.string.workers,
        route = Screen.Workers.route
    ),
    DrawerItem(
        icon = Icons.Default.Schedule,
        label = R.string.attendance,
        route = Screen.Attendance.route
    ),
    DrawerItem(
        icon = Icons.Default.AttachMoney,
        label = R.string.payroll,
        route = Screen.Payroll.route
    ),
    DrawerItem(
        icon = Icons.Default.Settings,
        label = R.string.settings,
        route = Screen.Settings.route
    )
)

data class DrawerItem(
    val icon: androidx.compose.material.icons.Icons.Filled,
    val label: Int,
    val route: String
)