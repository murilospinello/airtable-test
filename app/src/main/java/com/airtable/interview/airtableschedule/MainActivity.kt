package com.airtable.interview.airtableschedule

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.airtable.interview.airtableschedule.ui.timeline.TimelineScreen
import com.airtable.interview.airtableschedule.ui.timeline.TimelineViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TimelineScreen()
        }
    }
}
