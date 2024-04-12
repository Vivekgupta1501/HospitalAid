package com.example.hospitalaid.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hospitalaid.ui.screens.authScreen.AuthScreen
import com.example.hospitalaid.ui.screens.authScreen.LoginScreen
import com.example.hospitalaid.ui.screens.authScreen.SignInScreen
import com.example.hospitalaid.ui.screens.bottombar.BottomBarScreen
import com.example.hospitalaid.ui.screens.patientScreen.AppointmentScreen
import com.example.hospitalaid.ui.screens.patientScreen.DoctorsNoteScreen
import com.example.hospitalaid.ui.screens.patientScreen.LabScreen
import com.example.hospitalaid.ui.screens.patientScreen.MedicationScreen


@Composable
fun NavigationGraph(navController: NavHostController,modifier:Modifier = Modifier)
{
    NavHost(navController = navController, startDestination = "auth", modifier = modifier){
        navigation(startDestination = AuthScreen.Login.route,route = "auth")
        {
            composable(route = AuthScreen.Login.route)
            {
                LoginScreen(navController = navController)
            }
            composable(route = AuthScreen.Login.route)
            {
                SignInScreen()
            }
        }
        navigation(startDestination = BottomBarScreen.Appointment.route, route = "home"){
            composable(route = BottomBarScreen.Appointment.route)
            {
                AppointmentScreen()
            }
            composable(route =BottomBarScreen.Lab.route)
            {
                LabScreen()
            }
            composable(route =BottomBarScreen.Medications.route)
            {
                MedicationScreen()
            }
            composable(route =BottomBarScreen.DoctorsNote.route)
            {
                DoctorsNoteScreen()
            }
        }
    }
}