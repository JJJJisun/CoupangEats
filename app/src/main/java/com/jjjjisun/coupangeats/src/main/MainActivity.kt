package com.jjjjisun.coupangeats.src.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jjjjisun.coupangeats.src.main.fragment.ViewpagerAdapter
import com.jjjjisun.coupangeats.R
import com.jjjjisun.coupangeats.databinding.ActivityMainBinding
import com.jjjjisun.coupangeats.src.main.fragment.home.main.MainService

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //뷰페이저에 어댑터 연결
        binding.pager.adapter = ViewpagerAdapter(this)

        //리스너 연결
        binding.bottomNavigation.setOnNavigationItemSelectedListener(this)

        //뷰페이저 스와이프 막기
        binding.pager.isUserInputEnabled = false

    }

    //바텀 네비게이션
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_home -> {
                //뷰페이저의 현제 item에 첫번째 화면을 대입
                binding.pager.currentItem = 0
                return true
            }
            R.id.item_search -> {
                //뷰페이저의 현제 item에 두번째 화면을 대입
                binding.pager.currentItem = 1
                return true
            }
            R.id.item_favorite -> {
                //뷰페이저의 현제 item에 세번째 화면을 대입
                binding.pager.currentItem = 2
                return true
            }
            R.id.item_list -> {
                //뷰페이저의 현제 item에 네번째 화면을 대입
                binding.pager.currentItem = 3
                return true
            }
            R.id.item_my -> {
                //뷰페이저의 현제 item에 다섯번째 화면을 대입
                binding.pager.currentItem = 4
                return true
            }
            else -> {
                return false
            }
        }
    }

    fun setFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.pager, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}

