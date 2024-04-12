package com.example.hospitalaid.ui.screens.authScreen

sealed class AuthScreen(val route: String){
   object Login:AuthScreen(route = "Login")
    object SignIn: AuthScreen(route = "SignIn")
}
