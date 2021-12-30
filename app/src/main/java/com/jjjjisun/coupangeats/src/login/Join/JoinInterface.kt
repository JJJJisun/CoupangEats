package com.jjjjisun.coupangeats.src.login.Join

import com.jjjjisun.coupangeats.src.login.Join.models.JoinRequest
import com.jjjjisun.coupangeats.src.login.Join.models.JoinResponse
import retrofit2.Call
import retrofit2.http.*

interface JoinInterface {
    @POST("/app/users")
    fun postJoin(@Body params: JoinRequest) : Call<JoinResponse>

}
