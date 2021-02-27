package com.example.androiddevchallenge.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.base.PuppyDrawer
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.data.PuppySource
import dev.chrisbanes.accompanist.coil.CoilImage
import kotlinx.coroutines.launch

typealias OnListItemClicked = (Puppy) -> Unit

@Composable
fun PuppyHome(
    onListItemClicked: OnListItemClicked,
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
            modifier = modifier,
            onListItemClicked = onListItemClicked,
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
    modifier: Modifier = Modifier,
    onListItemClicked: OnListItemClicked,
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
                                item = exploreItem,
                                onListItemClicked = onListItemClicked
                            )
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
            .clickable { onListItemClicked(item) }
            .padding(top = 12.dp, bottom = 12.dp)
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
    }
}

@Composable
private fun PuppyImageContainer(content: @Composable () -> Unit) {
    Surface(Modifier.size(width = 60.dp, height = 60.dp), RoundedCornerShape(4.dp)) {
        content()
    }
}