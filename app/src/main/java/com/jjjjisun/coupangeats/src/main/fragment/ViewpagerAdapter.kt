package com.jjjjisun.coupangeats.src.main.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jjjjisun.coupangeats.src.main.fragment.favorite.FavoriteFragment
import com.jjjjisun.coupangeats.src.main.fragment.home.main.MainFragment
import com.jjjjisun.coupangeats.src.main.fragment.list.ListFragment
import com.jjjjisun.coupangeats.src.main.fragment.my.MyFragment
import com.jjjjisun.coupangeats.src.main.fragment.search.SearchFragment

class ViewpagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MainFragment()
            1 -> SearchFragment()
            2 -> FavoriteFragment()
            3 -> ListFragment()
            else -> MyFragment()
        }
    }
}