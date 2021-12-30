package com.jjjjisun.coupangeats.src.main.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.jjjjisun.coupangeats.databinding.ModalBottomSheetLayoutBinding
import com.jjjjisun.coupangeats.src.login.EmailLogin.EmailLoginActivity
import com.jjjjisun.coupangeats.src.login.Join.JoinActivity

class BottomSheetDialog : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //바인딩 설정
        val binding = ModalBottomSheetLayoutBinding.inflate(inflater, container, false)

        //이메일 로그인 화면으로 전환
        binding.btnBottomEmailLogin.setOnClickListener {
            startActivity(Intent(context, EmailLoginActivity::class.java))
        }

        //회원가입 화면으로 전환
        binding.tvBottomJoin.setOnClickListener {
            startActivity(Intent(context, JoinActivity::class.java))
        }


        return binding.root
    }
}