package com.jjjjisun.coupangeats.src.main.fragment.home


interface HomeFragmentView {

    //fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)

    //fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String)
}