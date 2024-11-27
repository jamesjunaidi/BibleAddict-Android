package com.junaidi.BibleAddict

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BibleAddictTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LazyColumn {
                        item {
                            Heading(Profile(5, 5, "James"))
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
