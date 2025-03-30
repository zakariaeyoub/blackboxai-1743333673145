package com.youb.workforcemanager

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.youb.workforcemanager.ui.theme.YOUBWorkforceManagerTheme
import java.util.Locale

class WorkforceManagerApp : Application() {
    companion object {
        lateinit var instance: WorkforceManagerApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        // Initialize default language
        setAppLanguage("en")
    }

    fun setAppLanguage(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        
        val config = Configuration()
        config.setLocale(locale)
        
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    YOUBWorkforceManagerTheme {
        // Main content preview will go here
    }
}