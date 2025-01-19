package com.junaidi.BibleAddict.maincomposables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.junaidi.BibleAddict.Models.Profile
import com.junaidi.BibleAddict.ViewModels.ProfileViewModel

/**
 * Main Home Screen composable displaying user profile, weekly checkboxes,
 * and buttons for API testing and navigation to notifications.
 * @param profileViewModel ViewModel to observe profile data.
 * @param navController Navigation controller to handle screen transitions.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(profileViewModel: ProfileViewModel, navController: NavHostController) {
    // Observing LiveData from the ViewModel
    val currency by profileViewModel.currency.observeAsState()
    val streak by profileViewModel.streak.observeAsState()
    val name by profileViewModel.name.observeAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            item {
                // Display the heading with profile data
                Heading(Profile(currency ?: 0, streak ?: 0, name ?: ""))
            }
            item {
                // Display the weekly checklist
                WeeklyCheckboxes()
            }
            item {
                // Button to test API calls
                MyButton(
                    onButtonClick = {
                        println("Button was clicked")
                        profileViewModel.fetchPost() { result ->
                            println("API Result in Compose UI: $result")
                            profileViewModel.updateName(result.take(6))
                        }
                    },
                    buttonName = "API Log Test Button"
                )
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                // Button to navigate to notification preferences
                NotificationButton(navController)
            }
        }
    }
}

/**
 * A button to navigate to the "Notification Preferences" screen.
 * @param navController Navigation controller to handle navigation.
 */
@Composable
fun NotificationButton(navController: NavHostController) {
    Button(
        onClick = { navController.navigate("notifications") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Go to Notification Preferences",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}

/**
 * A reusable button composable with customizable text and click action.
 * @param onButtonClick Lambda to execute on button click.
 * @param buttonName Text to display on the button.
 */
@Composable
fun MyButton(onButtonClick: () -> Unit, buttonName: String) {
    Button(
        onClick = onButtonClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = buttonName)
    }
}
