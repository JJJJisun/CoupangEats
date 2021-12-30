package com.jjjjisun.coupangeats.src.main.fragment.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jjjjisun.coupangeats.databinding.RecyclerCityItemBinding

class CityRecyclerAdapter(val context: Context, val cities: ArrayList<String>) :
    RecyclerView.Adapter<cityViewholder>() {

    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    lateinit var binding: RecyclerCityItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cityViewholder {
        binding = RecyclerCityItemBinding.inflate(inflater, parent, false)
        return cityViewholder(binding)
    }

    override fun onBindViewHolder(holder: cityViewholder, position: Int) {
        holder.city_name.text = cities[position]

        //도시 클릭이벤트
        holder.itemView.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return cities.size
    }

}

class cityViewholder(private val binding: RecyclerCityItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    var city_name = binding.tvCityName

    fun bind() {
        itemView.setOnClickListener {
            Intent()
        }
    }

}



