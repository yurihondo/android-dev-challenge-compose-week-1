/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.navigatioin

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
