package com.example.trendimages.presentation.ui.home


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.trendimages.R
import com.example.trendimages.databinding.ItemHomeRecyclerViewHorizontalBinding


class HomeAdapter(
    private var featuresImages : ArrayList<Int> = arrayListOf() ,
    private var featuresTitle : ArrayList<String> = arrayListOf() ,
    private var featuresDescription : ArrayList<String> = arrayListOf() ,
    private var itemClicked : OnClickedListener
) : RecyclerView.Adapter<HomeViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
           ItemHomeRecyclerViewHorizontalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
      holder.bind(featuresImages[position] , featuresTitle[position] , featuresDescription[position])
       holder.itemView.setOnClickListener {
           itemClicked.onImageListItemClick(it , featuresImages[position])
       }
            }




    override fun getItemCount(): Int {
       return featuresImages.size
    }
}