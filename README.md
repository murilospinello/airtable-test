# Airtable Timeline Assignment

## 📌 Description
This project implements an interactive timeline for visualizing events, arranged in multiple "lanes" to avoid overlaps.  
The size and position of each event are proportional to its start and end dates, with horizontal scrolling for navigation.

Architecture used: **MVVM** with **Koin** for dependency injection.  
UI developed with **Jetpack Compose**.

---

## ⏱ Time Spent
4 hours.

---

## ✅ What I Liked
I enjoyed implementing a feature in Compose using my own development strategies and patterns that I commonly adopt in real projects.

---

## 🔄 What I Would Do Differently
I would dedicate a full day for this type of exercise to:
- Deliver a more polished and professional result.
- Create a presentation video.
- Document each class in detail, explaining responsibilities and technical decisions.
- With more time, finishing up the DatePicker flow

---

## 🛠 How I Made My Decisions
- Chose **MVVM** as it is the most widely used architecture in modern Android projects.
- Used **Koin** for dependency injection due to its simplicity and flexibility.
- Kept `pxPerDay` fixed in the MVP to ensure faster and more predictable development.
- Managed state with `UIState and StateFlow` for clear and reactive integration with the UI.

---

## 🧪 How I Would Test (With More Time)
- Create unit tests for every critical function (especially lane calculation and date-to-pixel conversion).
- Validate visual behavior with instrumented Compose tests.
- Test edge cases: empty list, events on the same day, long events, and multiple overlapping events.

---

## ▶️ How to Run the Project
1. Download the project:
   ```bash
   git clone https://github.com/murilospinello/airtable-test



# [OLD] Airtable timeline assignment

## Expected implementation time:

4 hours

## High level objective:

Design and implement an app for visualizing events on a timeline.

## Details:

The timeline app will be used to display a number of events. Each event has at least 3 main pieces of information - the name,
the start date, and the end date. The events dates could overlap. The size of the event in the timeline should be
proportional to the number of days the event lasts.

The final design is up to you but your timeline app should attempt to arrange items in compact, space-efficient lanes.
If event A ends before event B starts, these events can share a lane.

The start and end dates will be formatted as `Date` objects. You don't need to worry about hours, minutes, seconds, or time zones.

You can assume every event's end date is the same or later than its start date.

Avoid using libraries that solve too much of the problem. General purpose libraries are definitely okay, but a library that
calculates the layout for a multi-lane timeline is not, for example.

## Scaffolding:

We include a basic app here to get you started. This app contains basic classes you can use to display your timeline, and it runs out of the box.
Please consider this as just a suggestion, and a way to help you get started.
If you dislike any architectural decisions, you're completely free to change and modify this code however you see fit, or even start completely fresh.

You can start writing your timeline code in the `TimelineScreen` class; it contains a TODO comment where you should display the data in swimlanes, as described above.

## Improvements:

After you have a basic read-only timeline app, here are some potential improvements to attempt as stretch goals:

- Allow edits of the events.
- Allow zooming in and out of the timeline.
- Allow dragging and dropping to change the start date and/or end date for an event.
- Any other polish or useful enhancements you can think of.

Include a README that covers:

- How long you spent on the assignment.
- What you like about your implementation.
- What you would change if you were going to do it again.
- How you made your design decisions. For example, if you looked at other timelines for inspiration, please note that.
- How you would test this if you had more time.
- Any special instructions on how to build/run your app.

What we're looking for:

- Clean, readable, maintainable code.
- A sensible user experience and design for the final product.
