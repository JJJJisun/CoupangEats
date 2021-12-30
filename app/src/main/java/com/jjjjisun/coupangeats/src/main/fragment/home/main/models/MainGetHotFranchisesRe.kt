package com.jjjjisun.coupangeats.src.main.fragment.home.main.models

data class MainGetHotFranchisesRe(
    //인기 프렌차이즈
    val couponIdx: Int,
    val couponName: String,
    val deliveryMaxTime: Int,
    val deliveryMinCost: Int,
    val deliveryMinTime: Int,
    val distance: String,
    val imgUrl1: String,
    val isEatsOriginal: String,
    val isFast: String,
    val name: String,
    val reviewNumber: Int,
    val star: String,
    val storeIdx: Int
)