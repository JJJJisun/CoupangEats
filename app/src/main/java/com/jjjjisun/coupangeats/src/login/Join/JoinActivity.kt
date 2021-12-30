package com.jjjjisun.coupangeats.src.login.Join

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.jjjjisun.coupangeats.config.ApplicationClass
import com.jjjjisun.coupangeats.config.BaseActivity
import com.jjjjisun.coupangeats.src.main.MainActivity
import com.jjjjisun.coupangeats.databinding.ActivityJoinBinding
import com.jjjjisun.coupangeats.src.login.Join.models.JoinRequest
import com.jjjjisun.coupangeats.src.login.Join.models.JoinResponse

class JoinActivity : BaseActivity<ActivityJoinBinding>(ActivityJoinBinding::inflate),
    JoinActivityView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //뒤로가기 버튼 클릭
        binding.ibJoinCancel.setOnClickListener {
            finish()
        }

        //동의하고 가입하기 버튼 클릭
        binding.btnJoinLogin.setOnClickListener {
            //필수 항목 모두 동의 시
            if (binding.checkboxE1.isChecked) {
                if (binding.checkboxE2.isChecked) {
                    if (binding.checkboxE3.isChecked) {
                        if (binding.checkboxE4.isChecked) {
                            if (binding.checkboxE5.isChecked) {

//                               //모두 동의
                                val id = binding.etJoinEmail.text.toString()
                                val password = binding.etJoinPasswd.text.toString()
                                val name = binding.etJoinName.text.toString()
                                val phoneNumber = binding.etJoinPhone.text.toString()
                                val postRequest = JoinRequest(
                                    id = id,
                                    password = password,
                                    name = name,
                                    phoneNumber = phoneNumber,
                                    signUpAgreeCheckBox = 1,
                                    socialLogIn = 0

                                )
                                showLoadingDialog(this)
                                JoinService(this).tryPostJoin(postRequest)
                                Log.d("jwt", ApplicationClass.sSharedPreferences.toString())
                                startActivity(Intent(this, MainActivity::class.java))

                                //필수 항목 클릭이 선택 안됐을 시 숨어있던 경고창 띄우기
                            } else {
                                binding.ivWarning.visibility = View.VISIBLE
                                binding.tvNotAgree.visibility = View.VISIBLE
                            }
                        } else {
                            binding.ivWarning.visibility = View.VISIBLE
                            binding.tvNotAgree.visibility = View.VISIBLE
                        }
                    } else {
                        binding.ivWarning.visibility = View.VISIBLE
                        binding.tvNotAgree.visibility = View.VISIBLE
                    }
                } else {
                    binding.ivWarning.visibility = View.VISIBLE
                    binding.tvNotAgree.visibility = View.VISIBLE
                }
            } else {
                binding.ivWarning.visibility = View.VISIBLE
                binding.tvNotAgree.visibility = View.VISIBLE
            }

        }

        //모두 동의하기 체크박스 전체선택
        binding.checkboxAgreeAll.setOnClickListener {
            //모두 동의하기 체크박스가 선택이 안됐을 시
            if (!binding.checkboxAgreeAll.isChecked) {
                binding.checkboxE1.isChecked = false
                binding.checkboxE2.isChecked = false
                binding.checkboxE3.isChecked = false
                binding.checkboxE4.isChecked = false
                binding.checkboxE5.isChecked = false

                binding.checkboxC1.isChecked = false
                binding.checkboxC2.isChecked = false

                binding.checkboxCc1.isChecked = false
                binding.checkboxCc2.isChecked = false
                binding.checkboxCc3.isChecked = false

                //모두 동의하기 체크박스가 선택이 됐을 시시
            } else {
                binding.checkboxE1.isChecked = true
                binding.checkboxE2.isChecked = true
                binding.checkboxE3.isChecked = true
                binding.checkboxE4.isChecked = true
                binding.checkboxE5.isChecked = true

                binding.checkboxC1.isChecked = true
                binding.checkboxC2.isChecked = true

                binding.checkboxCc1.isChecked = true
                binding.checkboxCc2.isChecked = true
                binding.checkboxCc3.isChecked = true
            }
        }
    }

    override fun onPostJoinSuccess(response: JoinResponse) {
        dismissLoadingDialog()
    }

    override fun onPostJoinFailure(message: String) {
        dismissLoadingDialog()
    }


}









