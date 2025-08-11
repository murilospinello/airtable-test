package com.airtable.interview.airtableschedule.domain.repositories

import com.airtable.interview.airtableschedule.domain.model.Event
import kotlinx.coroutines.flow.Flow

/**
 * A store for data related to events. Currently, this just returns sample data.
 */
interface EventDataRepository {
    fun getTimelineItems(): Flow<List<Event>>
}
