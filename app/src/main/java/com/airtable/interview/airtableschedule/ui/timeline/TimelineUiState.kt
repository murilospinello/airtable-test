package com.airtable.interview.airtableschedule.ui.timeline

import com.airtable.interview.airtableschedule.domain.model.Event

/**
 * UI state for the timeline screen.
 */

sealed interface TimeLineUiState {
    object Loading : TimeLineUiState
    object Success : TimeLineUiState
    data class Error(val msg: String) : TimeLineUiState
}