package com.mike.MPro.entity.daily

data class Follow(
    val followed: Boolean,
    val itemId: Int,
    val itemType: String
)