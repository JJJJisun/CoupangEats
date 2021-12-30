package com.jjjjisun.coupangeats.src.login.Join

import com.jjjjisun.coupangeats.config.ApplicationClass
import com.jjjjisun.coupangeats.src.login.Join.models.JoinRequest
import com.jjjjisun.coupangeats.src.login.Join.models.JoinResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JoinService(val view: JoinActivityView) {

    fun tryPostJoin(postJoinRequest: JoinRequest){

        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(JoinInterface::class.java)
        homeRetrofitInterface.postJoin(postJoinRequest).enqueue(object :
            Callback<JoinResponse>{

            override fun onResponse(call: Call<JoinResponse>, response: Response<JoinResponse>) {
                view.onPostJoinSuccess(response.body() as JoinResponse)
            }

            override fun onFailure(call: Call<JoinResponse>, t: Throwable) {
                view.onPostJoinFailure(t.message ?: "통신 오류")
            }
        })
    }

}
