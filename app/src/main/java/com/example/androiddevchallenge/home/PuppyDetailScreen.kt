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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.ui.theme.PuppyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PuppyDetailScreen(navController: NavController) {
    val data = navController.previousBackStackEntry?.arguments?.getSerializable("data") as Puppy?
    if (data == null) {
        navController.popBackStack()
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = rememberVectorPainter(Icons.Filled.ArrowBack),
                            contentDescription = ""
                        )
                    }
                },
                backgroundColor = MaterialTheme.colors.primary,
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = rememberVectorPainter(Icons.Filled.Favorite),
                    contentDescription = ""
                )
            }
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.LightGray),
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                contentAlignment = Alignment.TopCenter
            ) {
                Card(
                    modifier = Modifier.size(width = 320.dp, height = 169.dp),
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = MaterialTheme.colors.primary
                ) {
                }
                Surface(
                    modifier = Modifier
                        .size(width = 320.dp, height = 169.dp)
                        .absoluteOffset(x = (-10).dp, y = (-10).dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    CoilImage(
                        data = data.imageUrl,
                        fadeIn = true,
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        loading = {
                            Box(Modifier.fillMaxSize()) {
                                Image(
                                    modifier = Modifier
                                        .size(36.dp)
                                        .align(Alignment.Center),
                                    painter = painterResource(id = R.drawable.ic_dog_drawer),
                                    contentDescription = null
                                )
                            }
                        }
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentAlignment = Alignment.TopCenter,
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(16.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()

                    ) {
                        Text(
                            modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                            text = data.name,
                            fontSize = 32.sp,
                            style = TextStyle(fontWeight = FontWeight.Bold)
                        )
                        Text(
                            modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                            text = data.breed,
                            fontSize = 24.sp,
                            color = Color.LightGray,
                            fontStyle = FontStyle.Italic
                        )
                        Text(
                            modifier = Modifier.padding(8.dp),
                            text = data.description,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun LightPreview() {
    PuppyTheme {
        PuppyDetailScreen(rememberNavController())
    }
}
