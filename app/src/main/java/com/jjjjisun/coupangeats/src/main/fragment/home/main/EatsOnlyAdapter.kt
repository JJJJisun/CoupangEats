package com.jjjjisun.coupangeats.src.main.fragment.home.main

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jjjjisun.coupangeats.databinding.SmallStoreItemBinding
import com.jjjjisun.coupangeats.src.interfaces.StoreInterface
import com.jjjjisun.coupangeats.src.main.fragment.home.main.models.MainGetOnlyEatsRe

class EatsOnlyAdapter(
    private val context: Context,
    private val onlyEatsRe: List<MainGetOnlyEatsRe>,
    private val storeInterface: StoreInterface
) :
    RecyclerView.Adapter<EatsOnlyAdapter.ViewHolder>() {

    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    lateinit var binding: SmallStoreItemBinding

    //클릭 이벤트
    var clickAction: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = SmallStoreItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding, storeInterface, clickAction)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
//            ssImg.setImageResource(onlyEatsRe.get(position).imgUrl1 == null)
            ssName.text = onlyEatsRe[position].name
            ssRating.text = onlyEatsRe[position].star
            ssReview.text = onlyEatsRe[position].reviewNumber.toString()
            ssDistance.text = onlyEatsRe[position].distance
            ssRide.text = onlyEatsRe[position].deliveryMinCost.toString()
        }
    }

    override fun getItemCount(): Int {
        return onlyEatsRe.size
        Log.d("tag", onlyEatsRe.size.toString())
    }

    class ViewHolder(
        private val binding: SmallStoreItemBinding,
        private val storeInterface: StoreInterface,
        var clickAction: ((Int) -> Unit)? = null
    ) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
//        val ssImg = binding.ivSmallImg
        val ssName = binding.tvSmallName
        val ssRating = binding.tvSmallRating
        val ssReview = binding.tvSmallReview
        val ssDistance = binding.tvSmallDistance
        val ssRide = binding.tvRide
        val constraintItemLayout = binding.constraintItem

        //리사이클러뷰 아이템 클릭
        init {
            constraintItemLayout.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            storeInterface.onItemClicked(adapterPosition)
            clickAction?.invoke(adapterPosition)
        }
    }
}