package com.junaidi.BibleAddict

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.junaidi.BibleAddict.ui.theme.BibleAddictTheme
import com.junaidi.BibleAddict.Models.Profile
import com.junaidi.BibleAddict.maincomposables.Heading
import com.junaidi.BibleAddict.maincomposables.WeeklyCheckboxes
import com.junaidi.BibleAddict.Models.ProfileViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState

class MainActivity : ComponentActivity() {

    // Getting the ProfileViewModel
    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BibleAddictTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // Observe LiveData from ViewModel
                    val currency = profileViewModel.currency.observeAsState()
                    val streak = profileViewModel.streak.observeAsState()
                    val name = profileViewModel.name.observeAsState()

                    LazyColumn {
                        item {
                            Heading(Profile(currency.value ?: 0, streak.value ?: 0, name.value ?: ""))
                        }
                        item {
                            WeeklyCheckboxes()
                        }
                        item {
                            Text("Notification Selector") // Placeholder for notification section
                        }
                    }
                }
            }
        }
    }
}
