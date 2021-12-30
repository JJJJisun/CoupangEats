package com.jjjjisun.coupangeats.src.login.Join

import com.jjjjisun.coupangeats.src.login.Join.models.JoinResponse

interface JoinActivityView {

    fun onPostJoinSuccess(response: JoinResponse)

    fun onPostJoinFailure(message: String)
}