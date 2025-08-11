package com.airtable.interview.airtableschedule.domain.model

import java.util.Date

object SampleTimelineItems {
    private val year = 2025
    var timelineItems: List<Event> = listOf(
        Event(
            Date(year, 1, 1),
            Date(year, 1, 5),
            "First item"
        ),
        Event(
            Date(year, 1, 2),
            Date(year, 1, 8),
            "Second item"
        ),
        Event(
            Date(year, 1, 6),
            Date(year, 1, 13),
            "Another item"
        ),
        Event(
            Date(year, 1, 14),
            Date(year, 1, 14),
            "Another item"
        ),
        Event(
            Date(year, 2, 1),
            Date(year, 2, 15),
            "Third item"
        ),
        Event(
            Date(year, 1, 12),
            Date(year, 2, 16),
            "Fourth item with a super long name"
        ),
        Event(
            Date(year, 2, 1),
            Date(year, 2, 2),
            "Fifth item with a super long name"
        ),
        Event(
            Date(year, 1, 3),
            Date(year, 1, 5),
            "First item"
        ),
        Event(
            Date(year, 1, 4),
            Date(year, 1, 8),
            "Second item"
        ),
        Event(
            Date(year, 1, 6),
            Date(year, 1, 13),
            "Another item"
        )
    )
}