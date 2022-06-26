package com.example.trendimages.presentation.ui.home



import androidx.recyclerview.widget.RecyclerView
import com.example.trendimages.databinding.ItemHomeRecyclerViewHorizontalBinding

class HomeViewHolder(
    private var binding : ItemHomeRecyclerViewHorizontalBinding
): RecyclerView.ViewHolder(binding.root) {
     fun bind(images : Int , title : String ,description : String )
    {
        binding.ivItemImage.setImageResource(images)
        binding.tvItemTitle.text = title
        binding.tvItemDescription.text = description

    }


}