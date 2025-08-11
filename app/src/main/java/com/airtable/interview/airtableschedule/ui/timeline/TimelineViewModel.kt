package com.airtable.interview.airtableschedule.ui.timeline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.airtable.interview.airtableschedule.domain.model.Event
import com.airtable.interview.airtableschedule.domain.usecase.EventDataUseCase
import com.airtable.interview.airtableschedule.ui.theme.Strings.UNKNOWN_ERROR
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class TimelineViewModel(private val useCase: EventDataUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow<TimeLineUiState>(TimeLineUiState.Loading)
    val uiState: StateFlow<TimeLineUiState> = _uiState.asStateFlow()

    private val _events = MutableStateFlow<List<Event>>(emptyList())
    val events: StateFlow<List<Event>> = _events.asStateFlow()

    fun getTime() {
        viewModelScope.launch {
            useCase()
                .onStart { _uiState.value = TimeLineUiState.Loading }
                .catch { _uiState.value = TimeLineUiState.Error(it.message ?: UNKNOWN_ERROR) }
                .collect {
                    _uiState.value = TimeLineUiState.Success
                    _events.value = it
                }
        }
    }

    fun addEvent(event: Event) {
        _events.update {
            it.plus(event)
        }
    }
}
