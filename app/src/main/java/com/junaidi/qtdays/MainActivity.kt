package com.junaidi.qtdays

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.junaidi.qtdays.Styles.Styles
import com.junaidi.qtdays.ui.theme.BibleAddictTheme

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
                    Heading(5, 5)
                    // Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Heading(currency: Int, days: Int) {
    LazyRow (
        modifier = Modifier.fillMaxWidth().padding(start = 3.dp, end = 3.dp, top = 3.dp, bottom = 3.dp)
            ) {
        item {
            Box(
                modifier = Modifier.fillParentMaxWidth(), // Make sure the box takes the full width
                contentAlignment = Alignment.CenterStart // Align items to the start of the box
            ) {
                Text(
                    text = "$currency denarius",
                    modifier = Modifier.align(Alignment.CenterStart), // Align the left item
                    style = Styles.textStyle
                )
                Text(
                    "Streak: $days days",
                    modifier = Modifier.align(Alignment.CenterEnd), // Align the right item
                    style = Styles.textStyle
                )
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