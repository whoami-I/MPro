package com.mike.MPro.entity.daily

import com.mike.MPro.entity.daily.Data

data class Item(
    val adIndex: Int,
    val `data`: Data,
    val id: Int,
    val tag: Any,
    val type: String
)