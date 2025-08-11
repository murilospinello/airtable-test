package com.airtable.interview.airtableschedule.ui.timeline

import com.airtable.interview.airtableschedule.domain.model.Event

/**
 * UI state for the timeline screen.
 */
data class TimelineUiState(
    val events: List<Event> = emptyList(),
)

//sealed interface ChatsUiState {
//    object Loading : ChatsUiState
//    data class Success(val chats: List<ChatItem>) : ChatsUiState
//    data class Error(val msg: String) : ChatsUiState
//}