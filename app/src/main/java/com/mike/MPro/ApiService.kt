package com.mike.MPro

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("basil2style")
    fun getEntity():Call<MEntity>
}