package com.airtable.interview.airtableschedule.data.repositories

import com.airtable.interview.airtableschedule.data.local.EventDataSource
import com.airtable.interview.airtableschedule.domain.repositories.EventDataRepository
import com.airtable.interview.airtableschedule.domain.model.Event
import com.airtable.interview.airtableschedule.domain.model.SampleTimelineItems
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class EventDataRepositoryImpl(private val dataSource: EventDataSource) : EventDataRepository {
    override fun getTimelineItems(): Flow<List<Event>> {
        return dataSource.getTimelineItems()
    }
}
