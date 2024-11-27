package com.junaidi.BibleAddict.maincomposables

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeeklyCheckboxes() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp) // Reduced padding
    ) {
        Text(
            "Weekly Reading Checklist",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 4.dp) // Reduced bottom padding
        )

        // Display checkboxes for the current week, starting from Sunday
        for (dayOffset in 0..6) {
            SingleCheckbox(dayOffset)
            Spacer(modifier = Modifier.height(4.dp)) // Reduced spacing between rows
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleCheckbox(dayOffset: Int) {
    // Get today's date and adjust to the most recent Sunday
    val calendar: Calendar = Calendar.getInstance()
    val todayDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
    val daysToSubtract = todayDayOfWeek - Calendar.SUNDAY
    calendar.add(Calendar.DAY_OF_MONTH, -daysToSubtract)

    // Adjust the date to the corresponding day of the week
    calendar.add(Calendar.DAY_OF_MONTH, dayOffset)

    // Format the date to include the day of the week and date
    val dateFormatter = SimpleDateFormat("EEEE, MMM dd", Locale.getDefault())
    val formattedDate = dateFormatter.format(calendar.time)

    var text by remember { mutableStateOf("") } // State for text input
    var checked by remember { mutableStateOf(false) } // State for checkbox

    // Strike-through style logic
    val textDecoration = if (checked) TextDecoration.LineThrough else TextDecoration.None

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp) // Reduced vertical padding
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Display the formatted date with the day of the week
        Text(
            text = formattedDate,
            style = MaterialTheme.typography.bodyMedium.copy(textDecoration = textDecoration),
            modifier = Modifier.weight(1f)
        )

        // Smaller input for "What will you read?"
        OutlinedTextField(
            value = text,
            onValueChange = { newText -> text = newText },
            label = { Text("What to read?") },
            textStyle = MaterialTheme.typography.bodyMedium.copy(
                textDecoration = textDecoration,
                fontSize = MaterialTheme.typography.bodySmall.fontSize
            ),
            modifier = Modifier
                .weight(1.5f) // Adjusted weight for balance
                .padding(horizontal = 6.dp), // Reduced horizontal padding
            maxLines = 1 // Restrict to one line of input
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
