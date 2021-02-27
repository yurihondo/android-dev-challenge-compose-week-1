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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.*
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.home.OnListItemClicked
import com.example.androiddevchallenge.home.PuppyHome
import com.example.androiddevchallenge.home.SplashScreen
import com.example.androiddevchallenge.home.SplashState
import com.example.androiddevchallenge.ui.theme.PuppyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppyTheme {
                MainScreen(onListItemClicked = { /*TODO*/ })
            }
        }
    }
}

@Composable
fun MainScreen(onListItemClicked: OnListItemClicked) {
    PuppyTheme {
        Surface(color = MaterialTheme.colors.primary) {
            val transitionState = remember { MutableTransitionState(SplashState.Shown) }
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
                SplashScreen(
                    modifier = Modifier.alpha(splashAlpha),
                    onTimeout = { transitionState.targetState = SplashState.Completed }
                )
                MainContent(
                    modifier = Modifier.alpha(contentAlpha),
                    topPadding = contentTopPadding,
                    onListItemClicked = onListItemClicked,
                )
            }
        }
    }
}

@Composable
private fun MainContent(
    modifier: Modifier = Modifier,
    topPadding: Dp = 0.dp,
    onListItemClicked: OnListItemClicked
) {
    Column(modifier = modifier) {
        Spacer(Modifier.padding(top = topPadding))
        PuppyHome(
            modifier = modifier,
            onListItemClicked = onListItemClicked
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    PuppyTheme {
        MainScreen(onListItemClicked = { /*TODO*/ })
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    PuppyTheme(darkTheme = true) {
        MainScreen(onListItemClicked = { /*TODO*/ })
    }
}