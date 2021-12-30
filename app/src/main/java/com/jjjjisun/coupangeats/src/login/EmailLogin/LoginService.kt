package com.jjjjisun.coupangeats.src.login.EmailLogin

import com.jjjjisun.coupangeats.src.login.EmailLogin.models.LoginResponse
import com.jjjjisun.coupangeats.config.ApplicationClass
import com.jjjjisun.coupangeats.src.login.EmailLogin.models.LoginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService(val view: LoginActivityView) {

    fun tryPostLogin(postLoginRequest: LoginRequest){

        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(LoginInterface::class.java)
        homeRetrofitInterface.postUsers(postLoginRequest).enqueue(object :
            Callback<LoginResponse>{

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                view.onPostLoginSuccess(response.body() as LoginResponse)
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                view.onPostLoginFailure(t.message ?: "통신 오류")
            }
        })
    }

}
