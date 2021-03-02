package com.example.androiddevchallenge.ui.navigatioin

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.home.MainScreen
import com.example.androiddevchallenge.home.PuppyDetailScreen

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        // FIXME: Could not path a serializable argument currently.
        // Remove comment out any fixes to the Navigation library for Jetpack Compose.
//        composable(
//            route = "details?data = {data}",
//            arguments = listOf(
//                navArgument("data") {
//                    type = NavType.SerializableType(Puppy::class.java)
//                })
//        ) { entry ->
//            val data = entry.arguments?.getSerializable("data") as Puppy
//            PuppyDetailScreen(data)
//        }
        composable("details") { PuppyDetailScreen(navController = navController) }
    }
}