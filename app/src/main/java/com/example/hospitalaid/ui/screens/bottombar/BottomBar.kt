package com.example.hospitalaid.ui.screens.bottombar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.hospitalaid.ui.theme.md_theme_light_background
import com.example.hospitalaid.ui.theme.md_theme_light_primaryContainer

@Composable
fun BottomBar(bottomBarState:MutableState<Boolean>,navController: NavHostController)
{
    val screens = listOf(
        BottomBarScreen.Appointment,
        BottomBarScreen.Lab,
        BottomBarScreen.DoctorsNote,
        BottomBarScreen.Medications
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    
    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = {it}),
        exit = slideOutVertically(targetOffsetY = {it}),
        content = {
            BottomNavigation(
                backgroundColor = md_theme_light_primaryContainer
            ) {
                screens.forEach{screen->
                    AddItem(screen = screen,currentDestination = currentDestination,navController = navController)
                }
            }
        }
    )

}

@Composable
fun RowScope.AddItem(screen: BottomBarScreen,currentDestination: NavDestination?,navController: NavHostController){
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } ==true
    val background = if(selected) MaterialTheme.colorScheme.primary.copy(alpha = 0.6f) else Color.Transparent

    val contentColor = if (selected) Color.White else Color.Black

    BottomNavigationItem(
        label = { Text(text = screen.title)},
        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
        onClick = {
                  navController.navigate(screen.route)
                  {
                      popUpTo(navController.graph.findStartDestination().id)
                      launchSingleTop = true
                  }
        },
        icon = {
            Icon(painter = painterResource(id = screen.icon), contentDescription = "Nvaigation Icon",tint = Color.Unspecified)
        },
        alwaysShowLabel = false

    )
}
