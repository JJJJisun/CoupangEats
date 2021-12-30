package com.jjjjisun.coupangeats.src.main.fragment.home.main.models

data class MainGetOnlyEatsRe(

    //이츠에만 있는 맛집
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