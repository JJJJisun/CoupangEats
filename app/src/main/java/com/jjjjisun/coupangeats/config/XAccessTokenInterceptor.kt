package com.jjjjisun.coupangeats.config

import com.jjjjisun.coupangeats.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.jjjjisun.coupangeats.config.ApplicationClass.Companion.sSharedPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class XAccessTokenInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        //쉐어드 프리퍼런스에서 X_ACCESS_TOKEN이란 키로 값을 가져온다
        val jwtToken: String? = sSharedPreferences.getString(X_ACCESS_TOKEN, null)
        if (jwtToken != null) {
            builder.addHeader("X-ACCESS-TOKEN", jwtToken)
        }
        return chain.proceed(builder.build())
    }
}