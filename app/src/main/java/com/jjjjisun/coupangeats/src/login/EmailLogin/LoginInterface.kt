package com.jjjjisun.coupangeats.src.login.EmailLogin

import com.jjjjisun.coupangeats.src.login.EmailLogin.models.LoginResponse
import com.jjjjisun.coupangeats.src.login.EmailLogin.models.LoginRequest
import retrofit2.Call
import retrofit2.http.*

interface LoginInterface {
    @POST("/app/users/logIn")
    fun postUsers(@Body params: LoginRequest) : Call<LoginResponse>

}
