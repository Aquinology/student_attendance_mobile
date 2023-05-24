package com.example.attendance.utils

import java.text.SimpleDateFormat
import java.util.*

fun Date(index: Int) : String {
    val format = "dd.MM.yyyy"
    val calendar = Calendar.getInstance()
    when (index) {
        -1 -> calendar.add(Calendar.DAY_OF_YEAR, -1)
        0 -> { /* do nothing */ }
        1 -> calendar.add(Calendar.DAY_OF_YEAR, 1)
        else -> throw IllegalArgumentException("Incorrect index")
    }
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    return dateFormat.format(calendar.time)
}
