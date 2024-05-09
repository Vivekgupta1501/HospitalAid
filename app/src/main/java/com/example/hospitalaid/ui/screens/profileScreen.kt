package com.example.hospitalaid.ui.screens

import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.hospitalaid.model.User
import com.example.hospitalaid.viewModel.AppViewModel

@Composable
fun profileScreen(viewModel: AppViewModel,user: User,navController: NavController){
    Button(onClick = { viewModel.signOutUser(navController) }) {
        Text(text = "LogOut")
    }
}