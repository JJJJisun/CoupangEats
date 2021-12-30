package com.jjjjisun.coupangeats.src.main.fragment.home.main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.jjjjisun.coupangeats.R
import com.jjjjisun.coupangeats.config.BaseFragment
import com.jjjjisun.coupangeats.databinding.FragmentMainBinding
import com.jjjjisun.coupangeats.src.interfaces.StoreInterface
import com.jjjjisun.coupangeats.src.main.fragment.BottomSheetDialog
import com.jjjjisun.coupangeats.src.main.fragment.home.main.models.MainGetOnlyEatsRe
import com.jjjjisun.coupangeats.src.main.fragment.home.main.models.MainResponse
import com.jjjjisun.coupangeats.src.main.fragment.home.store.StoreActivity

data class CategoryCard(val foodImg: Int, val foodName: String)

data class SmallStoreDate(
    val img: Int,
    val name: String,
    val rating: String,
    val review: String,
    val distance: String,
    val ride: String
)

class MainFragment :
    BaseFragment<FragmentMainBinding>(FragmentMainBinding::bind, R.layout.fragment_main),
    StoreInterface, MainActivityView {

    private var numBanner = 3
    private var currentPosition = Int.MAX_VALUE / 2

//    private lateinit var onlyEatsRe: List<MainGetOnlyEatsRe>

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var smallStoreAdapter: SmallStoreAdapter
    private lateinit var eatsOnlyAdapter: EatsOnlyAdapter

    //카테고리 리스트
    var categoryCardArrayList = ArrayList<CategoryCard>()

    //더미 데이터
    private var storeData = ArrayList<SmallStoreDate>()

    //api 이츠 데이터
    private var onlyEatsRe = ArrayList<MainGetOnlyEatsRe>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //데이터 받기
        showLoadingDialog(requireContext())
        MainService(this).tryGetMain()

        //검색 아이콘 색상 변경(바텀네비게이션 아이콘과 동일)
        binding.ivMainFSearch.setColorFilter(Color.parseColor("#000000"))

        //로그인 전 상단 위치 클릭 시 바텀시트 구현
        binding.layoutMainFLocation.setOnClickListener {
            val bottomSheetDialog: BottomSheetDialog = BottomSheetDialog()
            bottomSheetDialog.show(parentFragmentManager, bottomSheetDialog.tag)
        }

        //뷰페이저 어댑터
        binding.pagerMain.adapter = BannerPagerAdapter(getBannerList())
        binding.pagerMain.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        //뷰페이저가 켜지면서 넘어가는것을 방지
        binding.pagerMain.setCurrentItem(currentPosition, false)
        binding.tvTextTotal.text = numBanner.toString()

        //현재 몇번째 배너인지 보여주는 숫자를 변경함
        binding.pagerMain.apply {
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.tvTextCurrent.text = "${(position % 3) + 1}"
                }
            })
        }

        //카테고리 데이터
        categoryCardArrayList.apply {
            add(CategoryCard(R.drawable.category_1, "신규 맛집"))
            add(CategoryCard(R.drawable.category_2, "1인분"))
            add(CategoryCard(R.drawable.category_3, "한식"))
            add(CategoryCard(R.drawable.category_4, "치킨"))
            add(CategoryCard(R.drawable.category_5, "분식"))
            add(CategoryCard(R.drawable.category_6, "돈까스"))
            add(CategoryCard(R.drawable.category_7, "족발/보쌈"))
        }

        //카테고리 어댑터 연결
        categoryAdapter = CategoryAdapter(requireContext(), categoryCardArrayList)
        binding.categoryRecycler.adapter = categoryAdapter

        //더미 데이터
        storeData.apply {
            for (i in 0..2) {
                add(
                    SmallStoreDate(
                        R.drawable.small_store_1, "낙지천국 은평구점", "4.9",
                        "(196)", "0.8km", "무료배달"
                    )
                )
                add(
                    SmallStoreDate(
                        R.drawable.small_store_2, "돈파블로", "4.8",
                        "(577)", "2.0km", "베달비 2,900원"
                    )
                )
                add(
                    SmallStoreDate(
                        R.drawable.small_store_3, "전주청기와감자탕", "5.0",
                        "(108)", "0.6km", "배달비 1,500원"
                    )
                )
            }
        }

        //더미데이터 어댑터 연결
        smallStoreAdapter = SmallStoreAdapter(requireContext(), storeData, this)

        //이츠온리 어댑터 연결
        eatsOnlyAdapter = EatsOnlyAdapter(requireContext(), onlyEatsRe, this)
        binding.itRecycler.adapter = eatsOnlyAdapter

        Log.d("tag", eatsOnlyAdapter.itemCount.toString())

        //더미데이터 어댑터 연결
        smallStoreAdapter = SmallStoreAdapter(requireContext(), storeData, this)
        binding.hotRecycler.adapter = smallStoreAdapter


        //새로 들어왔어요 어댑터 연결
        smallStoreAdapter = SmallStoreAdapter(requireContext(), storeData, this)
        binding.newRecycler.adapter = smallStoreAdapter


        //람다 클릭 이벤트
        binding.itRecycler.adapter = smallStoreAdapter

        //어댑터 아이템 클릭 이벤트
        smallStoreAdapter.clickAction = { clickedPosition ->
            Log.d("TAG", "clickAction: clickedPosition: $clickedPosition")
        }

    }

    //배너
    private fun getBannerList(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.banner_1, R.drawable.banner_2, R.drawable.banner_3)
    }

    // small store 인터페이스
    override fun onItemClicked(position: Int) {
        Log.d("TAG", "onItemClicked: position: $position")
        activity?.let {
            val intent = Intent(it, StoreActivity::class.java)
//            val smallStoreName = StoreData.get(position).name
            val smallStoreName = storeData.get(position).name
            intent.putExtra("smallStoreName", smallStoreName)
            it.startActivity(intent)
        }
    }

    override fun onMainSuccess(response: MainResponse) {
        dismissLoadingDialog()
        showCustomToast("데이터 받아오기 성공")
    }

    override fun onMainFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
    }

}