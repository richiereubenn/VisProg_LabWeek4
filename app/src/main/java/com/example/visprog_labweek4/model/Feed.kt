package com.example.visprog_labweek4.model

import java.util.Date

data class Feed(
    val name: String,
    val pic_path: String,
    val content_path: String,
    val like_active: Boolean,
    val like_inactive: Boolean,
    val like: Int,
    val caption: String,
    val date: String
)
