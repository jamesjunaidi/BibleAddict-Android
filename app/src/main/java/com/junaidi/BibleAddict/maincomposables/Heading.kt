package com.junaidi.BibleAddict.maincomposables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.junaidi.BibleAddict.Models.Profile
import com.junaidi.BibleAddict.Styles.Styles

/*
This Composable function contains the logic for our header
The elements are a currency count and streak count
 */
@Composable
fun Heading(profile: Profile) {
    Column {

        WelcomeHeader(name = profile.name)

        QuantitativeSection(profile.currency, profile.streak)
    }
}

@Composable
fun WelcomeHeader(name: String) {
    Box(
        modifier = Modifier.fillMaxSize(), // Ensures the Box takes up the entire available space
        contentAlignment = Alignment.Center // Centers the content inside the Box
    ) {
        Text(
            text = "Welcome ${name}!",
            style = Styles.welcomeTextStyle,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun QuantitativeSection(currency: Int, days: Int,) {
    LazyRow (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 3.dp, end = 3.dp, top = 3.dp, bottom = 3.dp)
    ) {
        item {
            Box(
                modifier = Modifier.fillParentMaxWidth(), // Make sure the box takes the full width
                contentAlignment = Alignment.CenterStart // Align items to the start of the box
            ) {
                Text(
                    text = "$currency Denarius",
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
