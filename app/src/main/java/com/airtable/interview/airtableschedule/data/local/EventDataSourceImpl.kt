package com.airtable.interview.airtableschedule.data.local

import com.airtable.interview.airtableschedule.domain.model.Event
import com.airtable.interview.airtableschedule.domain.model.SampleTimelineItems
import com.airtable.interview.airtableschedule.domain.repositories.EventDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

/**
 * A store for data related to events. Currently, this just returns sample data.
 */

class EventDataSourceImpl : EventDataSource {
    override fun getTimelineItems(): Flow<List<Event>> {
        return flowOf(SampleTimelineItems.timelineItems)
    }
}