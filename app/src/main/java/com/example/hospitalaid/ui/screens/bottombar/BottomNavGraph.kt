package com.example.hospitalaid.ui.screens.bottombar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hospitalaid.ui.screens.patientScreen.AppointmentScreen
import com.example.hospitalaid.ui.screens.patientScreen.DoctorsNoteScreen
import com.example.hospitalaid.ui.screens.patientScreen.LabScreen
import com.example.hospitalaid.ui.screens.patientScreen.MedicationScreen

@Composable
fun BottomNavGraph(navController: NavHostController,modifier: Modifier = Modifier){
    NavHost(navController = navController, startDestination = BottomBarScreen.Appointment.route, modifier = modifier){
        composable(route= BottomBarScreen.Appointment.route){
            AppointmentScreen()
        }
        composable(route = BottomBarScreen.Lab.route){
            LabScreen()
        }
        composable(route = BottomBarScreen.Medications.route){
            MedicationScreen()
        }
        /*
        composable(route = BottomBarScreen.DoctorsNote.route){
            DoctorsNoteScreen()
        }*/
    }
}