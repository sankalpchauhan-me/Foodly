package me.sankalpchauhan.foodly_catalouge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import me.sankalpchauhan.foodly_catalouge.ui.AppCatalog

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCatalog()
        }
    }
}