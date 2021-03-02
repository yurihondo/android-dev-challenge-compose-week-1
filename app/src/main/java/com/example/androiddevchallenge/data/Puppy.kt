package com.example.androiddevchallenge.data

import androidx.compose.runtime.Immutable
import java.io.Serializable

@Immutable
@kotlinx.serialization.Serializable
data class Puppy(
    val name: String,
    val breed: String,
    val imageUrl: String,
    val description: String = ""
): Serializable