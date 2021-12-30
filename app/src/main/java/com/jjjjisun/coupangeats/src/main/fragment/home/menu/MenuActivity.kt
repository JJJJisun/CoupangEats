package com.jjjjisun.coupangeats.src.main.fragment.home.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jjjjisun.coupangeats.databinding.ActivityMenuBinding
import com.jjjjisun.coupangeats.src.main.fragment.home.cart.CartActivity

class MenuActivity : AppCompatActivity() {

    lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //배달 카트에 담기 클릭 시
        binding.btnMenu.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

    }


}