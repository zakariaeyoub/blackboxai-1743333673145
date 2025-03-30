package com.youb.workforcemanager.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.youb.workforcemanager.R
import com.youb.workforcemanager.WorkforceManagerApp

@Composable
fun LanguageSwitcher(
    modifier: Modifier = Modifier
) {
    var showDialog by remember { mutableStateOf(false) }
    val currentLanguage = remember { mutableStateOf("en") }

    Row(
        modifier = modifier
            .clickable { showDialog = true }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Language,
            contentDescription = stringResource(R.string.language)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = if (currentLanguage.value == "en") stringResource(R.string.english) 
                 else stringResource(R.string.arabic),
            style = MaterialTheme.typography.labelLarge
        )
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(stringResource(R.string.language)) },
            text = {
                Column {
                    ListItem(
                        headlineContent = { Text(stringResource(R.string.english)) },
                        leadingContent = {
                            RadioButton(
                                selected = currentLanguage.value == "en",
                                onClick = {
                                    currentLanguage.value = "en"
                                    WorkforceManagerApp.instance.setAppLanguage("en")
                                }
                            )
                        }
                    )
                    ListItem(
                        headlineContent = { Text(stringResource(R.string.arabic)) },
                        leadingContent = {
                            RadioButton(
                                selected = currentLanguage.value == "ar",
                                onClick = {
                                    currentLanguage.value = "ar"
                                    WorkforceManagerApp.instance.setAppLanguage("ar")
                                }
                            )
                        }
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text(stringResource(android.R.string.ok))
                }
            }
        )
    }
}