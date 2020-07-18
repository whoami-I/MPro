package com.mike.MPro

import com.mike.MPro.entity.daily.DiscoveryEntity
import retrofit2.Call
import retrofit2.http.GET

interface DiscoveryApiService {
    @GET("api/v7/index/tab/discovery")
    fun getDiscovery():Call<DiscoveryEntity>
}