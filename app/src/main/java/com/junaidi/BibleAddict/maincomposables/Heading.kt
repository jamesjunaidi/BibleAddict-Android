package com.junaidi.BibleAddict.maincomposables
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.junaidi.BibleAddict.Models.Profile
import com.junaidi.BibleAddict.Styles.Styles

/*
This Composable function contains the logic for our header.
The elements are a currency count and streak count.
 */
@Composable
fun Heading(profile: Profile) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Welcome Header Section
        WelcomeHeader(name = profile.name)

        Spacer(modifier = Modifier.height(16.dp))

        // Quantitative Section
        QuantitativeSection(currency = profile.currency, streak = profile.streak)
    }
}

@Composable
fun WelcomeHeader(name: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Welcome, $name!",
            style = Styles.welcomeTextStyle.copy(fontSize = 24.sp), // Adjust font size for better visibility
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun QuantitativeSection(currency: Int, streak: Int) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFEDEDED), // Light background color
            contentColor = Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Currency Section
            Text(
                text = "$currency Denarius",
                style = Styles.textStyle.copy(fontSize = 18.sp)
            )

            // Streak Section
            Text(
                text = "Streak: $streak days",
                style = Styles.textStyle.copy(fontSize = 18.sp)
            )
        }
    }
}
