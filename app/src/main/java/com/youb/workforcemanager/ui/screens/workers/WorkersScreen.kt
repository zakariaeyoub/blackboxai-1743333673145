package com.youb.workforcemanager.ui.screens.workers

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.youb.workforcemanager.R
import com.youb.workforcemanager.model.Worker
import com.youb.workforcemanager.ui.components.WorkerCard
import com.youb.workforcemanager.ui.components.WorkforceAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkersScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }
    val workers = listOf(
        Worker(
            id = "001",
            name = "Ahmed Mohammed",
            position = "Carpenter",
            site = "Dubai Marina Tower",
            imageUrl = null
        ),
        Worker(
            id = "002",
            name = "Youssef Ali",
            position = "Electrician",
            site = "Palm Jumeirah Villa",
            imageUrl = null
        ),
        Worker(
            id = "003",
            name = "Mohammed Hassan",
            position = "Plumber",
            site = "Downtown Office",
            imageUrl = null
        )
    )

    Scaffold(
        topBar = {
            WorkforceAppBar(
                title = stringResource(R.string.workers),
                navigationIcon = Icons.Default.ArrowBack,
                onNavigationClick = { navController.popBackStack() }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* TODO: Add new worker */ },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.add_worker)
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            // Search bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text(stringResource(R.string.search)) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Workers list
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(workers) { worker ->
                    WorkerCard(
                        worker = worker,
                        onClick = { /* TODO: Navigate to worker details */ }
                    )
                }
            }
        }
    }
}