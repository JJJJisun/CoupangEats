package com.jjjjisun.coupangeats.src.main.fragment.home.store

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.appbar.CollapsingToolbarLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.appbar.AppBarLayout
import com.jjjjisun.coupangeats.R
import com.jjjjisun.coupangeats.databinding.ActivityStoreBinding
import com.jjjjisun.coupangeats.src.main.fragment.home.menu.MenuActivity
import kotlin.math.abs

class StoreActivity : AppCompatActivity() {

    lateinit var binding: ActivityStoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))

        val title = " "

        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title

//        binding.appBar.addOnOffsetChangedListener(inivView)

        binding.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (abs(verticalOffset) - appBarLayout.totalScrollRange == 0) { //접혔을 때
                binding.fab.visibility = View.INVISIBLE
            } else { //펴졌을 때
                binding.fab.visibility = View.VISIBLE
            }
        })

        var layout = findViewById<ConstraintLayout>(R.id.constraint_menu)
        layout.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }

        //데이터 전달
        if (intent.hasExtra("smallStoreName")) {
//            textView.text = intent.getStringExtra("nameKey")
            /* "nameKey"라는 이름의 key에 저장된 값이 있다면
               textView의 내용을 "nameKey" key에서 꺼내온 값으로 바꾼다 */
            val receivedStoreName = intent.getStringExtra("smallStoreName")
            Toast.makeText(this, receivedStoreName, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "전달된 이름이 없습니다", Toast.LENGTH_SHORT).show()
        }

    }

}