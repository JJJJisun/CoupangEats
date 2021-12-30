package com.jjjjisun.coupangeats.src.main.fragment.home.main.models

data class MainResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: ArrayList<MainResult>
)