package com.jjjjisun.coupangeats.src.main.fragment.home.main.models

data class MainGetNewStoresRe(
    //새로 들어왔어요
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
    val star: Any,
    val storeIdx: Int
)