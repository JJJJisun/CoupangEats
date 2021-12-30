package com.jjjjisun.coupangeats.src.login.Join.models

data class JoinResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: JoinResult
)