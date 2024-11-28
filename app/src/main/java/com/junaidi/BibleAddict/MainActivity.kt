package com.junaidi.BibleAddict

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.junaidi.BibleAddict.ui.theme.BibleAddictTheme
import com.junaidi.BibleAddict.Models.ProfileViewModel
import com.junaidi.BibleAddict.maincomposables.HomeScreen
import com.junaidi.BibleAddict.maincomposables.NotificationPreferencesScreen

class MainActivity : ComponentActivity() {
    // Getting the ProfileViewModel
    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BibleAddictTheme {
                AppContent(profileViewModel)
            }
        }
    }
}

@Composable
fun AppContent(profileViewModel: ProfileViewModel) {
    // Initialize NavController
    val navController = rememberNavController()

    // Set up Navigation
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(profileViewModel, navController)
        }
        composable("notifications") {
            NotificationPreferencesScreen()
        }
    }
}



