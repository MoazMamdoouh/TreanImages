package com.example.trendimages.presentation.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trendimages.databinding.ItemSearchImagesBinding
import com.example.trendimages.domain.model.search.SearchResponse

class SearchAdapter(
    private val searchImagesList: SearchResponse
) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchAdapter.SearchViewHolder {
        return SearchViewHolder(
            ItemSearchImagesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchAdapter.SearchViewHolder, position: Int) {
        holder.bind(searchImagesList.images[position])
    }

    override fun getItemCount(): Int {
        return searchImagesList.images.size
    }

    class SearchViewHolder(
        private var binding: ItemSearchImagesBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(images: String) {
            binding.imageUrl = images
        }
    }

}