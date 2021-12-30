package com.jjjjisun.coupangeats.src.main.fragment.home

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.jjjjisun.coupangeats.config.BaseFragment
import com.jjjjisun.coupangeats.R
import com.jjjjisun.coupangeats.databinding.FragmentHomeBinding
import com.jjjjisun.coupangeats.src.main.MainActivity
import com.jjjjisun.coupangeats.src.main.fragment.BottomSheetDialog
import com.jjjjisun.coupangeats.src.main.fragment.home.main.MainFragment

class HomeFragment :
    BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home) {

    private val cities = ArrayList<String>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //검색 아이콘 색상 변경(바텀네비게이션 아이콘과 동일)
        binding.ivHomeFSearch.setColorFilter(Color.parseColor("#000000"))

        //로그인 전 상단 위치 클릭 시 바텀시트 구현
        binding.layoutHomeFLocation.setOnClickListener {
            val bottomSheetDialog: BottomSheetDialog = BottomSheetDialog()
            bottomSheetDialog.show(parentFragmentManager, bottomSheetDialog.tag)
        }

        //도시명 데이터
        cities.add("서울시 강남구")
        cities.add("서울시 송파구")
        cities.add("서울시 서초구")
        cities.add("서울시 관악구")
        cities.add("경기도 용인시")
        cities.add("서울시 동작구")
        cities.add("서울시 강동구")
        cities.add("서울시 마포구")
        cities.add("서울시 광진구")
        cities.add("서울시 용산구")

        cities.add("서울시 성동구")
        cities.add("서울시 강서구")
        cities.add("서울시 양천구")
        cities.add("서울시 영등포구")
        cities.add("서울시 구로구")
        cities.add("서울시 금천구")
        cities.add("서울시 서대문구")
        cities.add("서울시 은평구")
        cities.add("서울시 중구")
        cities.add("서울시 중랑구")

        //리사이클러뷰 연결,,
        binding.cityRecycler.adapter = CityRecyclerAdapter(requireContext(), cities)
        binding.cityRecycler.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

    }

}