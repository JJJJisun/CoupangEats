package com.jjjjisun.coupangeats.src.main.fragment.home.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jjjjisun.coupangeats.databinding.CategoryItemBinding

class CategoryAdapter(
    private val context: Context,
    val categoryCardArrayList: ArrayList<CategoryCard>
) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    lateinit var binding: CategoryItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = CategoryItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.foodImg.setImageResource(categoryCardArrayList.get(position).foodImg)
        holder.foodName.text = categoryCardArrayList[position].foodName
    }

    override fun getItemCount(): Int {
        return categoryCardArrayList.size
    }

    class ViewHolder(private val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val foodImg = binding.ivFoodImg
        val foodName = binding.tvFoodText
    }
}