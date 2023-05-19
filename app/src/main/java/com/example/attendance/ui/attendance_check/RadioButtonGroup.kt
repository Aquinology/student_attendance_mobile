package com.example.attendance.ui.attendance_check

import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import com.example.attendance.ui.theme.AttendanceTheme
import com.example.attendance.R

@Composable
fun RadioButtonGroup() {

    val selectedValue = remember { mutableStateOf("") }
    val items = listOf(
        "Absent" to MaterialTheme.colorScheme.error,
        "Late" to MaterialTheme.colorScheme.tertiary,
        "Present" to MaterialTheme.colorScheme.secondary
    )

    Row() {
        items.forEach { item ->
            Column(
                modifier = Modifier.selectable(
                    selected = (selectedValue.value == item.first),
                    onClick = { selectedValue.value = item.first },
                    role = Role.RadioButton
                ).padding(all = 10.dp)
            ) {
                IconToggleButton(
                    checked = selectedValue.value == item.first,
                    onCheckedChange = { selectedValue.value = item.first },
                    modifier = Modifier.size(28.dp)
                ) {
                    Icon(
                        painter = painterResource(
                            if (selectedValue.value == item.first) {
                                R.drawable.ic_circle_checked
                            } else {
                                R.drawable.ic_circle_outline
                            }
                        ),
                        contentDescription = null,
                        tint = item.second
                    )
                }
            }
        }
    }

}

@Preview(
    name = "Light Mode",
    showBackground = true
)
@Composable
private fun PreviewRadioButtonGroup() {
    AttendanceTheme {
        RadioButtonGroup()
    }
}