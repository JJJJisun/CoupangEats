package com.jjjjisun.coupangeats.src.main.fragment.home.cart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jjjjisun.coupangeats.databinding.ActivityCartBinding
import com.jjjjisun.coupangeats.src.main.MainActivity

class CartActivity : AppCompatActivity() {

    lateinit var binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //상단 x버튼 클릭 시
        binding.ibCartCancel.setOnClickListener {
            finish()
        }

        binding.btnCart.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}