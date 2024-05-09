package com.example.hospitalaid.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hospitalaid.model.User
import com.example.hospitalaid.ui.screens.authScreen.AuthScreen
import com.example.hospitalaid.ui.screens.authScreen.LoginScreen
import com.example.hospitalaid.ui.screens.authScreen.SignInScreen
import com.example.hospitalaid.ui.screens.bottombar.BottomBarScreen
import com.example.hospitalaid.ui.screens.patientScreen.AppointmentScreen
import com.example.hospitalaid.ui.screens.patientScreen.DoctorsNoteScreen
import com.example.hospitalaid.ui.screens.patientScreen.LabScreen
import com.example.hospitalaid.ui.screens.patientScreen.MedicationScreen
import com.example.hospitalaid.ui.screens.profileScreen
import com.example.hospitalaid.viewModel.AppViewModel


@Composable
fun NavigationGraph(navController: NavHostController,modifier:Modifier = Modifier,viewModel: AppViewModel,user: User)
{
    NavHost(navController = navController, startDestination = if(viewModel.userLoggedInStatus()) "home" else "auth", modifier = modifier){
        navigation(startDestination = AuthScreen.Login.route,route = "auth")
        {
            composable(route = AuthScreen.Login.route)
            {
                LoginScreen(navController = navController,viewModel = viewModel,user = user)
            }
            composable(route = AuthScreen.SignIn.route)
            {
                SignInScreen(navController = navController,viewModel = viewModel,user = user)
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
            composable(route = BottomBarScreen.Profile.route)
            {
                profileScreen(viewModel, user,navController)
            }
           /* composable(route =BottomBarScreen.DoctorsNote.route)
            {
                DoctorsNoteScreen()
            }*/
        }
    }
}