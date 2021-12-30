package com.jjjjisun.coupangeats.src.main.fragment.home.main

import com.jjjjisun.coupangeats.src.main.fragment.home.main.models.MainResponse

interface MainActivityView {

    fun onMainSuccess(response: MainResponse)

    fun onMainFailure(message: String)
}