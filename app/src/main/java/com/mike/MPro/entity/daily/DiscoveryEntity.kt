package com.mike.MPro.entity.daily

data class DiscoveryEntity(
    val adExist: Boolean,
    val count: Int,
    val itemList: List<Item>,
    val nextPageUrl: Any,
    val total: Int
)