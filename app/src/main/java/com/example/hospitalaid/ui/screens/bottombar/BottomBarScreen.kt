package com.example.hospitalaid.ui.screens.bottombar

import android.graphics.drawable.Icon
import com.example.hospitalaid.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
){
    object Appointment: BottomBarScreen(
        title = "Appointment",
        route = "Appointment",
        icon = R.drawable.baseline_edit_calendar_24

    )
    object Lab: BottomBarScreen(
        title = "Lab",
        route = "Lab",
        icon = R.drawable.baseline_insert_chart_24
    )
    object Medications: BottomBarScreen(
        title = "Medications",
        route = "Medications",
        icon = R.drawable.baseline_medication_24
    )
    object Profile: BottomBarScreen(
        title = "Profile",
        route = "Profile",
        icon = R.drawable.baseline_person_24
    )

/*
    object DoctorsNote: BottomBarScreen(
        title = "Doctors Note",
        route = "Doctors Note",
        icon = R.drawable.baseline_lightbulb_24
    )*/
}
