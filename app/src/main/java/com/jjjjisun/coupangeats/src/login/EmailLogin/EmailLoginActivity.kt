package com.jjjjisun.coupangeats.src.login.EmailLogin

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import com.jjjjisun.coupangeats.src.login.EmailLogin.models.LoginRequest
import com.jjjjisun.coupangeats.src.login.EmailLogin.models.LoginResponse
import com.jjjjisun.coupangeats.config.ApplicationClass
import com.jjjjisun.coupangeats.config.BaseActivity
import com.jjjjisun.coupangeats.src.login.Join.JoinActivity
import com.jjjjisun.coupangeats.databinding.ActivityEmailLoginBinding
import com.jjjjisun.coupangeats.src.main.MainActivity

class EmailLoginActivity :
    BaseActivity<ActivityEmailLoginBinding>(ActivityEmailLoginBinding::inflate),
    LoginActivityView {

    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //x버튼 클릭 시 액티비티 끝
        binding.ibEmailCancel.setOnClickListener {
            finish()
        }

        //회원가입 버튼 클릭
        binding.tvJoin.setOnClickListener {
            startActivity(Intent(this, JoinActivity::class.java))
        }

        //로그인 버튼 클릭
        ApplicationClass.sSharedPreferences = getSharedPreferences("pref", 0)
        editor = ApplicationClass.sSharedPreferences.edit()

        binding.btnEmailLogin.setOnClickListener {
            val id = binding.etEmailLogin.text.toString()
            val password = binding.etEmailPw.text.toString()

            Log.d("jwt", ApplicationClass.sSharedPreferences.toString())
            val postRequest = LoginRequest(id = id, password = password)
            showLoadingDialog(this)
            LoginService(this).tryPostLogin(postRequest)
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onPostLoginSuccess(response: LoginResponse) {
        dismissLoadingDialog()
        editor.putString(ApplicationClass.X_ACCESS_TOKEN, response.result.jwt)
        editor.apply()
        Log.d("jwt", editor.toString())
        response.message?.let { showCustomToast(it) }
    }

    override fun onPostLoginFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }
}