package com.junaidi.BibleAddict.maincomposables
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material.Checkbox
//import androidx.compose.material.OutlinedTextField
//import androidx.compose.material.Text
//import androidx.compose.material.TextField
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import com.junaidi.BibleAddict.Styles.Styles
//import java.util.*
//
///*
//Contains the 7 days of the week
//TODO: Add logic for getting the proper day for the week.
// */
//@Composable
//fun WeeklyCheckboxes() {
//    Column(
//        modifier = Modifier.padding(8.dp)
//    ) {
//        Text("Checklist UI: ")
//        SingleCheckbox()
//        SingleCheckbox()
//        SingleCheckbox()
//        SingleCheckbox()
//        SingleCheckbox()
//        SingleCheckbox()
//        SingleCheckbox()
//    }
//}
//
//// TODO: Add text area for entering a description of what will be done that week.
//@Composable
//fun SingleCheckbox() {
//    val date: Calendar = Calendar.getInstance()
//
//    var text by remember { mutableStateOf("") } // State to hold the input text
//
//    var checked by remember {
//        mutableStateOf(false)
//    }
//
//    Row(
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//
//        Text(
//            "Date ${date.get(Calendar.MONTH) + 1}/${date.get(Calendar.DAY_OF_MONTH)}",
//            style = Styles.checklistTextStyle
//        )
//
//        OutlinedTextField(
//            value = text,
//            onValueChange = { newText -> text = newText },
//            label = { Text("What will you read this day?")},
//            modifier = Modifier.padding(start = 6.dp, end = 6.dp)
//        )
//
//        Checkbox(
//            checked = checked,
//            onCheckedChange = { checked = it },
//        )
//    }
//}


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeeklyCheckboxes() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            "Weekly Reading Checklist",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        for (i in 1..7) {
            SingleCheckbox(dayNumber = i)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleCheckbox(dayNumber: Int) {
    val date: Calendar = Calendar.getInstance()
    date.add(Calendar.DAY_OF_MONTH, dayNumber - 1) // Adjust for each day of the week

    var text by remember { mutableStateOf("") } // Ensure non-null initialization
    var checked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Day ${dayNumber}: ${date.get(Calendar.MONTH) + 1}/${date.get(Calendar.DAY_OF_MONTH)}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f)
        )

        OutlinedTextField(
            value = text ?: "", // Fallback to an empty string if null
            onValueChange = { newText -> text = newText },
            label = { Text("What will you read?") },
            modifier = Modifier
                .weight(2f)
                .padding(horizontal = 8.dp),
            textStyle = MaterialTheme.typography.bodyMedium
        )

        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it },
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colorScheme.primary,
                uncheckedColor = MaterialTheme.colorScheme.onSurface
            )
        )
    }
}
