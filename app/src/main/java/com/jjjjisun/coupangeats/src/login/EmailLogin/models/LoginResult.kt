package com.jjjjisun.coupangeats.src.login.EmailLogin.models

import com.google.gson.annotations.SerializedName

data class LoginResult(
	val userIdx : Int,
	val jwt: String

)
