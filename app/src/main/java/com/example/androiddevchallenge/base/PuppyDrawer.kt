package com.example.androiddevchallenge.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.PuppyTheme

private val screens = listOf("Find Puppies", "Favorite Puppies")

@Composable
fun PuppyDrawer(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.primary)
                .padding(start = 24.dp, top = 48.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_dog_drawer),
                contentDescription = "",
                modifier = Modifier
                    .width(72.dp)
                    .height(92.dp)
            )
        }
        for (screen in screens) {
            Spacer(Modifier.height(24.dp))
            Text(
                text = screen,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(start = 24.dp)
            )
        }
    }
}

@Preview
@Composable
fun CraneDrawerPreview() {
    PuppyTheme() {
        PuppyDrawer()
    }
}