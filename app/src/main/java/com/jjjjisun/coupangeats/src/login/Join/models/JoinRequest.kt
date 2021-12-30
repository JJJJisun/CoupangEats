package com.jjjjisun.coupangeats.src.login.Join.models

data class JoinRequest(
    val id: String,
    val name: String,
    val password: String,
    val phoneNumber: String,
    val signUpAgreeCheckBox: Int,
    val socialLogIn: Int
)