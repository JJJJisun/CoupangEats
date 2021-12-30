package com.jjjjisun.coupangeats.src.main.fragment.home.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jjjjisun.coupangeats.R
import kotlin.collections.ArrayList

class BannerPagerAdapter(var bannerList: ArrayList<Int>) :
    RecyclerView.Adapter<BannerPagerAdapter.PagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = Int.MAX_VALUE

    var item = bannerList


    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.banner_list_item, parent, false)) {

//        val banner = itemView.iv_banner!!
    }
}