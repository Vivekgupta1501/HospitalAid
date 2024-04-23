package com.example.hospitalaid.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hospitalaid.R
import com.example.hospitalaid.ui.navigation.NavigationGraph
import com.example.hospitalaid.ui.screens.authScreen.LoginScreen
import com.example.hospitalaid.ui.screens.bottombar.BottomBar
import com.example.hospitalaid.ui.screens.bottombar.BottomBarScreen
import com.example.hospitalaid.ui.screens.bottombar.BottomNavGraph
import com.example.hospitalaid.ui.theme.HospitalAidTheme
import com.example.hospitalaid.ui.theme.md_theme_light_primary
import com.example.hospitalaid.ui.theme.md_theme_light_primaryContainer


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    val bottomBarState  = rememberSaveable { mutableStateOf(false) }
    val topBarState  = rememberSaveable { mutableStateOf(false) }

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    when(navBackStackEntry?.destination?.route)
    {
        /*
        BottomBarScreen.DoctorsNote.route->{
            bottomBarState.value = true
            topBarState.value = true
        }*/
        BottomBarScreen.Appointment.route->{
            bottomBarState.value = true
            topBarState.value = true
        }
        BottomBarScreen.Lab.route->{
            bottomBarState.value = true
            topBarState.value = true
        }
        BottomBarScreen.Medications.route->{
            bottomBarState.value = true
            topBarState.value = true
        }
        else ->
        {
            bottomBarState.value = false
            topBarState.value = false
        }

    }
    HospitalAidTheme {
       Scaffold(topBar = { TopBar(topBarState) },
           bottomBar = { BottomBar(bottomBarState = bottomBarState,navController = navController) }) { innerPadding->
           NavigationGraph(navController = navController, modifier = Modifier.padding(innerPadding))

       }
      // LoginScreen()
   }
}
@Composable
fun TopBar(topBarState: MutableState<Boolean>)
{
    AnimatedVisibility(
        visible = topBarState.value,
        enter = slideInVertically(initialOffsetY = {-it}),
        exit = slideOutVertically (targetOffsetY = {-it}),
        content = {
            TopAppBar(backgroundColor = md_theme_light_primary, elevation = 24.dp) {
                Row {
                    Image(painter = painterResource(id = R.drawable.baseline_supervised_user_circle_24), contentDescription = "Profile Picture")
                    Text(text = "Hi! Vivek", color = Color.White)
                }
            }
        }
    )

}



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MainScreenPreview()
{
    MainScreen()
}


