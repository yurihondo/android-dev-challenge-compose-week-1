package com.example.androiddevchallenge.data

import android.net.Uri
import androidx.compose.runtime.Immutable

@Immutable
data class Dog(
    val name: String,
    val breed: String,
    val imageUrl: String
)