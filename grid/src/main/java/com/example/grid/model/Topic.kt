package com.example.grid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @DrawableRes val imageResId : Int,
    @StringRes val titleResId : Int,
    val topicId : Int
)
