package com.example.hospitalaid.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.hospitalaid.R
import com.example.hospitalaid.ui.screens.authScreen.LoginScreen
import com.example.hospitalaid.ui.screens.bottombar.BottomBar
import com.example.hospitalaid.ui.screens.bottombar.BottomNavGraph
import com.example.hospitalaid.ui.theme.HospitalAidTheme
import com.example.hospitalaid.ui.theme.md_theme_light_primary
import com.example.hospitalaid.ui.theme.md_theme_light_primaryContainer


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    val navController = rememberNavController()
   HospitalAidTheme {
       /*Scaffold(topBar = { TopBar() },
           bottomBar = { BottomBar(navController = navController) }) { innerPadding->
           BottomNavGraph(navController = navController,modifier = Modifier.padding(innerPadding))

       }*/
       LoginScreen()
   }
}
@Composable
fun TopBar()
{
    TopAppBar(backgroundColor = md_theme_light_primary, elevation = 24.dp) {
        Row {
            Image(painter = painterResource(id = R.drawable.baseline_supervised_user_circle_24), contentDescription = "Profile Picture")
            Text(text = "Hi! Vivek", color = Color.White)
        }
    }
}



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MainScreenPreview()
{
    MainScreen()
}


