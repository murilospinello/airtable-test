package com.airtable.interview.airtableschedule.domain.usecase

import com.airtable.interview.airtableschedule.domain.repositories.EventDataRepository


class EventDataUseCase(private val repository: EventDataRepository) {
    operator fun invoke() = repository.getTimelineItems()
}