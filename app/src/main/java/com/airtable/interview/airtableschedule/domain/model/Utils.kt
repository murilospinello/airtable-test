package com.airtable.interview.airtableschedule.domain.model

import android.annotation.SuppressLint
import com.airtable.interview.airtableschedule.ui.theme.Strings.DATE_FORMAT
import java.text.SimpleDateFormat
import java.util.Date

fun emptyString() = ""

fun doNothing() = emptyString()

@SuppressLint("SimpleDateFormat")
fun Date.toDate(): String? {
    val sdf = SimpleDateFormat(DATE_FORMAT)
    return sdf.format(this)
}