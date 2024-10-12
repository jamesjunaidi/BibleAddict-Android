package com.junaidi.BibleAddict.maincomposables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.junaidi.BibleAddict.Styles.Styles
import java.util.*

/*
Contains the 7 days of the week
TODO: Add logic for getting the proper day for the week.
 */
@Composable
fun WeeklyCheckboxes() {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Text("Checklist UI: ")
        SingleCheckbox()
        SingleCheckbox()
        SingleCheckbox()
        SingleCheckbox()
        SingleCheckbox()
        SingleCheckbox()
        SingleCheckbox()
    }
}

// TODO: Add text area for entering a description of what will be done that week.
@Composable
fun SingleCheckbox() {
    val date: Calendar = Calendar.getInstance()

    var text by remember { mutableStateOf("") } // State to hold the input text

    var checked by remember {
        mutableStateOf(false)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            "Date ${date.get(Calendar.MONTH) + 1}/${date.get(Calendar.DAY_OF_MONTH)}",
            style = Styles.checklistTextStyle
        )

        OutlinedTextField(
            value = text,
            onValueChange = { newText -> text = newText },
            label = { Text("What will you read this day?")},
            modifier = Modifier.padding(start = 6.dp, end = 6.dp)
        )

        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it },
        )
    }
}