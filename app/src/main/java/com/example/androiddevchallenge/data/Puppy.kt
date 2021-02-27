package com.example.androiddevchallenge.data

import androidx.compose.runtime.Immutable

@Immutable
data class Puppy(
    val name: String,
    val breed: String,
    val imageUrl: String
)