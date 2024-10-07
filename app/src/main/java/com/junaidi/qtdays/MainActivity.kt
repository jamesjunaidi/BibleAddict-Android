package com.junaidi.qtdays

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.junaidi.qtdays.ui.theme.BibleAddictTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.junaidi.qtdays.Models.Profile
import com.junaidi.qtdays.maincomposables.Heading
import java.util.Calendar

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
                            SingleCheckbox()
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
fun SingleCheckbox() {
    val date: Calendar = Calendar.getInstance()

    var checked by remember {
        mutableStateOf(false)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            "Date ${date.get(Calendar.MONTH) + 1}/${date.get(Calendar.DAY_OF_MONTH)}"
        )
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )
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