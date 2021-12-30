package com.jjjjisun.coupangeats.src.login.EmailLogin

import com.jjjjisun.coupangeats.src.login.EmailLogin.models.LoginResponse

interface LoginActivityView {

    fun onPostLoginSuccess(response: LoginResponse)
    fun onPostLoginFailure(message: String)
}