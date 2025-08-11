package com.airtable.interview.airtableschedule.ui.timeline

import android.app.DatePickerDialog
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.airtable.interview.airtableschedule.domain.model.Event
import com.airtable.interview.airtableschedule.domain.model.SampleTimelineItems
import com.airtable.interview.airtableschedule.domain.model.doNothing
import com.airtable.interview.airtableschedule.domain.model.toDate
import com.airtable.interview.airtableschedule.ui.theme.Dimens
import com.airtable.interview.airtableschedule.ui.theme.Strings
import com.airtable.interview.airtableschedule.ui.theme.Strings.SELECT_DATE
import com.airtable.interview.airtableschedule.ui.theme.Strings.SELECT_FINAL_DATE
import com.airtable.interview.airtableschedule.ui.theme.Strings.SELECT_INITIAL_DATE
import com.airtable.interview.airtableschedule.ui.theme.Strings.TO_ADD
import org.koin.androidx.compose.koinViewModel
import java.util.Calendar
import java.util.Date
import java.util.concurrent.TimeUnit


@Composable
fun TimelineScreen() {

    val viewModel: TimelineViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val events by viewModel.events.collectAsStateWithLifecycle()


    LaunchedEffect(Unit) {
        viewModel.getTime()
    }

    when (uiState) {
        is TimeLineUiState.Error -> doNothing()
        TimeLineUiState.Loading -> doNothing()
        is TimeLineUiState.Success -> TimelineView(events, viewModel)
    }
}

@Preview
@Composable
fun PreviewTimeLineScreen() {
    TimelineView(SampleTimelineItems.timelineItems, viewModel())
}

@Composable
private fun TimelineView(
    events: List<Event> = listOf(),
    viewModel: TimelineViewModel
) {

    val minDate = events.minOf { it.startDate }
    val maxDate = events.maxOf { it.endDate }

    val diffMillis = maxDate.time - minDate.time
    val totalDays = TimeUnit.MILLISECONDS.toDays(diffMillis) + 1


    val pxPerDay = 30.dp
    val laneHeight = 48.dp
    val laneGap = 8.dp

    val totalWidth = (totalDays * pxPerDay.value).dp

    Column(modifier = Modifier.background(Color.White)) {
        if (events.isEmpty()) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(Dimens.spacingL),
                contentAlignment = Alignment.Center
            ) {
                Text(Strings.NO_EVENTS)
            }
        } else {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Timeline (${minDate.toDate()} until ${maxDate.toDate()})",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(Dimens.spacingS)
                )
            }

            val context = LocalContext.current

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(onClick = {
                    calendarPicker(context = context, onDateSelected = { date ->
                        // I didn't have enough time to implement this.
                    })
                }) {
                    Text(text = SELECT_INITIAL_DATE)
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = SELECT_INITIAL_DATE
                    )
                }

                IconButton(onClick = {
                    calendarPicker(context = context, onDateSelected = { date ->
                        // I didn't have enough time to implement this.
                    })
                }) {
                    Text(text = SELECT_FINAL_DATE)
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = SELECT_FINAL_DATE
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color.White)
                    .verticalScroll(rememberScrollState())
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = Dimens.spacingL, vertical = Dimens.spacingS)
            ) {

                Box(modifier = Modifier.width(totalWidth)) {

                    Row(
                        modifier = Modifier
                            .height(Dimens.pxHeaderHeight)
                            .fillMaxWidth()
                    ) {

                        for (i in 1..totalDays.toInt()) {
                            Box(modifier = Modifier.width(pxPerDay)) {
                                Text(text = "Day $i")
                            }
                        }
                    }

                    Box(modifier = Modifier.offset(y = Dimens.pxHeaderHeight)) {
                        events.forEach { event ->

                            val startOffsetDays =
                                TimeUnit.MILLISECONDS.toDays(event.startDate.time - minDate.time)
                            val durationDays =
                                TimeUnit.MILLISECONDS.toDays(event.endDate.time - event.startDate.time) + 1

                            val offsetX = (startOffsetDays * pxPerDay.value).dp
                            val width = (durationDays * pxPerDay.value).dp
                            val offsetY = (laneHeight + laneGap) * events.indexOf(event)

                            EventView(
                                event = event,
                                offsetX = offsetX,
                                width = width,
                                offsetY = offsetY,
                                height = laneHeight
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun EventView(event: Event, offsetX: Dp, width: Dp, offsetY: Dp, height: Dp) {
    Column(
        modifier = Modifier
            .offset(x = offsetX, y = offsetY)
            .width(width)
            .height(height)
            .background(Color(0xFF4CAF50)),
    ) {
        Text(text = event.name)
        Text(text = "${event.startDate.toDate()} > ${event.endDate.toDate()}")
    }
}

private fun calendarPicker(
    context: Context,
    onDateSelected: (Date) -> Unit
) {
    val calendar = Calendar.getInstance()

    DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            calendar.set(year, month, dayOfMonth)
            onDateSelected(calendar.time)
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    ).show()
}
