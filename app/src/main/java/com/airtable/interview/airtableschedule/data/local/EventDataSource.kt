package com.airtable.interview.airtableschedule.data.local

import com.airtable.interview.airtableschedule.domain.model.Event
import kotlinx.coroutines.flow.Flow

/**
 * A store for data related to events. Currently, this just returns sample data.
 */

interface EventDataSource {
    fun getTimelineItems(): Flow<List<Event>>
}
