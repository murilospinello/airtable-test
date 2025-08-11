package com.airtable.interview.airtableschedule.ui.timeline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.airtable.interview.airtableschedule.domain.usecase.EventDataUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


class TimelineViewModel(private val useCase: EventDataUseCase): ViewModel() {

    val uiState: StateFlow<TimelineUiState> = useCase.invoke()
        .map(::TimelineUiState)
        .stateIn(
            viewModelScope,
            initialValue = TimelineUiState(),
            started = SharingStarted.WhileSubscribed()
        )
}
