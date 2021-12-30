package com.jjjjisun.coupangeats.src.main.fragment.home.main

import com.jjjjisun.coupangeats.config.ApplicationClass
import com.jjjjisun.coupangeats.src.main.fragment.home.main.models.MainResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainService(val view: MainActivityView) {

    fun tryGetMain() {
        val mainRetrofitInterface = ApplicationClass.sRetrofit.create(MainInterface::class.java)
        mainRetrofitInterface.getMain().enqueue(object :
            Callback<MainResponse> {

            override fun onResponse(call: Call<MainResponse>, response: Response<MainResponse>) {
                view.onMainSuccess(response.body() as MainResponse)
            }

            override fun onFailure(call: Call<MainResponse>, t: Throwable) {
                view.onMainFailure(t.message ?: "통신 오류")
            }
        })
    }

}
