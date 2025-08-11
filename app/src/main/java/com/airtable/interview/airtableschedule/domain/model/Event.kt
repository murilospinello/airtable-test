package com.airtable.interview.airtableschedule.domain.model

import java.util.Date

data class Event(val startDate: Date, val endDate: Date, val name: String)