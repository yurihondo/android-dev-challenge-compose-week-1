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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.base.PuppyDrawer
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.data.PuppySource
import dev.chrisbanes.accompanist.coil.CoilImage
import kotlinx.coroutines.launch

typealias OnListItemClicked = (Puppy) -> Unit

@Composable
fun PuppyHome(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val drawerState = rememberDrawerState(DrawerValue.Open)
    ModalDrawer(
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen,
        drawerContent = { PuppyDrawer() },
    ) {
        val scope = rememberCoroutineScope()
        PuppyHomeContent(
            navController = navController,
            modifier = modifier,
            openDrawer = {
                scope.launch {
                    drawerState.open()
                }
            },
            puppyList = PuppySource.getPuppies()
        )
    }
}

@Composable
fun PuppyHomeContent(
    navController: NavController,
    modifier: Modifier = Modifier,
    openDrawer: () -> Unit,
    puppyList: List<Puppy>
) {
    Column {
        TopAppBar(
            title = {},
            navigationIcon = {
                IconButton(onClick = openDrawer) {
                    Icon(
                        painter = rememberVectorPainter(Icons.Filled.Menu),
                        contentDescription = ""
                    )
                }
            }
        )
        Surface(modifier = modifier.fillMaxSize(), color = Color.White) {
            Column(modifier = Modifier.padding(start = 24.dp, top = 20.dp, end = 24.dp)) {
                Text(
                    text = "Puppies",
                    style = MaterialTheme.typography.caption.copy(color = Color.DarkGray)
                )
                Spacer(Modifier.height(8.dp))
                LazyColumn(
                    modifier = Modifier.weight(1f),
                ) {
                    items(puppyList) { exploreItem ->
                        Column(Modifier.fillParentMaxWidth()) {
                            PuppyItem(
                                modifier = Modifier.fillParentMaxWidth(),
                                item = exploreItem
                            ) { puppy ->
                                navController.currentBackStackEntry?.arguments?.putSerializable(
                                    "data",
                                    puppy
                                )
                                navController.navigate("details")
                            }
                            Divider(color = Color.LightGray)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PuppyItem(
    modifier: Modifier = Modifier,
    item: Puppy,
    onListItemClicked: OnListItemClicked
) {
    Row(
        modifier = modifier
            .size(84.dp)
            .clickable { onListItemClicked(item) }
            .padding(top = 12.dp, bottom = 12.dp),
    ) {
        PuppyImageContainer {
            CoilImage(
                data = item.imageUrl,
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
        Spacer(Modifier.width(24.dp))
        Column {
            Text(
                text = item.name,
                style = MaterialTheme.typography.h6
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = item.breed,
                style = MaterialTheme.typography.caption.copy(color = Color.DarkGray)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                painter = rememberVectorPainter(Icons.Filled.Favorite),
                contentDescription = ""
            )
        }
    }
}

@Composable
private fun PuppyImageContainer(content: @Composable () -> Unit) {
    Surface(Modifier.size(width = 60.dp, height = 60.dp), RoundedCornerShape(4.dp)) {
        content()
    }
}
