package com.airtable.interview.airtableschedule.di

import com.airtable.interview.airtableschedule.data.local.EventDataSource
import com.airtable.interview.airtableschedule.data.local.EventDataSourceImpl
import com.airtable.interview.airtableschedule.data.repositories.EventDataRepositoryImpl
import com.airtable.interview.airtableschedule.domain.repositories.EventDataRepository
import com.airtable.interview.airtableschedule.domain.usecase.EventDataUseCase
import com.airtable.interview.airtableschedule.ui.timeline.TimelineViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {

    viewModelOf(::TimelineViewModel)

    singleOf(::EventDataUseCase)

    singleOf(::EventDataRepositoryImpl) bind EventDataRepository::class

    singleOf(::EventDataSourceImpl) bind EventDataSource::class

}