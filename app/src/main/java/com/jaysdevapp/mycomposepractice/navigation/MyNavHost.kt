package com.jaysdevapp.mycomposepractice.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jaysdevapp.mycomposepractice.features.ui.InputName
import com.jaysdevapp.mycomposepractice.features.ui.MyFirstScreen


sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail/{studyName}") {
        fun createRoute(studyName: String) = "detail/$studyName"
    }
}

@Composable
fun myNavHost(){

    /*
    * navController - 운전 기사
    * navHost       - 터미널
    * Composable    - 목적지
    * */

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            InputName(navController = navController)
        }
        composable(Screen.Detail.route) { backStackEntry ->
            val whom = backStackEntry.arguments?.getString("studyName") ?: "none"
            MyFirstScreen( whom, onBack = { navController.popBackStack() })
        }
    }

}