package com.junaidi.qtdays.maincomposables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import java.util.*

/*
Contains the 7 days of the week
TODO: Add logic for getting the proper day for the week.
 */
@Composable
fun WeeklyCheckboxes() {
    Column {
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