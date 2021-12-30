package com.jjjjisun.coupangeats.src.main.fragment.home.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jjjjisun.coupangeats.databinding.SmallStoreItemBinding
import com.jjjjisun.coupangeats.src.interfaces.StoreInterface

class SmallStoreAdapter(
    private val context: Context,
    val StoreData: ArrayList<SmallStoreDate>,
    private val storeInterface: StoreInterface
) :
    RecyclerView.Adapter<SmallStoreAdapter.ViewHolder>() {

    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    lateinit var binding: SmallStoreItemBinding

    var clickAction: ((Int) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        binding = SmallStoreItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding, storeInterface, clickAction)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            ssImg.setImageResource(StoreData.get(position).img)
            ssName.text = StoreData[position].name
            ssRating.text = StoreData[position].rating
            ssReview.text = StoreData[position].review
            ssDistance.text = StoreData[position].distance
            ssRide.text = StoreData[position].ride
        }
    }

    override fun getItemCount(): Int {
        return StoreData.size
    }

    class ViewHolder(
        private val binding: SmallStoreItemBinding,
        private val storeInterface: StoreInterface,
        var clickAction: ((Int) -> Unit)? = null
    ) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        val ssImg = binding.ivSmallImg
        val ssName = binding.tvSmallName
        val ssRating = binding.tvSmallRating
        val ssReview = binding.tvSmallReview
        val ssDistance = binding.tvSmallDistance
        val ssRide = binding.tvRide
        val constraintItemLayout = binding.constraintItem

        init {
            constraintItemLayout.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            storeInterface.onItemClicked(adapterPosition)

            clickAction?.invoke(adapterPosition)
        }
    }
}