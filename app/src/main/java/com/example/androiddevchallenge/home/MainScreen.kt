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
package com.example.androiddevchallenge.home

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

var isFirstLaunch = true

@Composable
fun MainScreen(navController: NavController) {
    Surface(color = MaterialTheme.colors.primary) {
        val transitionState = remember {
            if (isFirstLaunch) MutableTransitionState(SplashState.Shown)
            else MutableTransitionState(SplashState.Completed)
        }
        val transition = updateTransition(transitionState)
        val splashAlpha by transition.animateFloat(
            transitionSpec = { tween(durationMillis = 100) }
        ) {
            if (it == SplashState.Shown) 1f else 0f
        }
        val contentAlpha by transition.animateFloat(
            transitionSpec = { tween(durationMillis = 300) }
        ) {
            if (it == SplashState.Shown) 0f else 1f
        }
        val contentTopPadding by transition.animateDp(
            transitionSpec = { spring(stiffness = Spring.StiffnessLow) }
        ) {
            if (it == SplashState.Shown) 100.dp else 0.dp
        }

        Box {
            if (isFirstLaunch) {
                SplashScreen(
                    modifier = Modifier.alpha(splashAlpha),
                    onTimeout = {
                        isFirstLaunch = false
                        transitionState.targetState = SplashState.Completed
                    }
                )
            }
            MainContent(
                navController = navController,
                modifier = Modifier.alpha(contentAlpha),
                topPadding = contentTopPadding,
            )
        }
    }
}

@Composable
private fun MainContent(
    navController: NavController,
    modifier: Modifier = Modifier,
    topPadding: Dp = 0.dp,
) {
    Column(modifier = modifier) {
        Spacer(Modifier.padding(top = topPadding))
        PuppyHome(
            navController = navController,
            modifier = modifier
        )
    }
}
