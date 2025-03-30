package com.youb.workforcemanager.ui.screens.settings

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.youb.workforcemanager.ui.theme.YOUBWorkforceManagerTheme

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    YOUBWorkforceManagerTheme {
        SettingsScreen(navController = rememberNavController())
    }
}