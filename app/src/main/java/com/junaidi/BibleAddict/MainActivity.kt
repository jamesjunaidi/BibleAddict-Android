package com.junaidi.BibleAddict

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                            Text("Checklist UI")
                            WeeklyCheckboxes()
                        }

                        item {
                            Text("Notification Selector")
                        }
                    }

                    // Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BibleAddictTheme {
        Greeting("Android")
    }
}