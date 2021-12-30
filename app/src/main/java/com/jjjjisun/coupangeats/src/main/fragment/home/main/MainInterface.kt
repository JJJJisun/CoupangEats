package com.jjjjisun.coupangeats.src.main.fragment.home.main

import com.jjjjisun.coupangeats.src.main.fragment.home.main.models.MainResponse
import retrofit2.Call
import retrofit2.http.*

interface MainInterface {
    @GET("/app/homes/1/1")
    fun getMain() : Call<MainResponse>
}
