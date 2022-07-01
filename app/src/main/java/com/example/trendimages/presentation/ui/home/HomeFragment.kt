package com.example.trendimages.presentation.ui.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trendimages.R
import com.example.trendimages.databinding.FragmentHomeBinding


class HomeFragment : Fragment() , OnClickedListener{
  private lateinit var adapter : HomeAdapter
  private lateinit var binding : FragmentHomeBinding
  private val featuresImages = ArrayList<Int>()
  private val featuresTitle = ArrayList<String>()
  private val featuresDescription = ArrayList<String>()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         binding  = FragmentHomeBinding.inflate(inflater)
        //functions call
        initiateRecyclerView()



        return binding.root
    }

    private fun initiateRecyclerView() {
        //images
        featuresImages.add(R.drawable.search)
        featuresImages.add(R.drawable.tamblate)
        featuresImages.add(R.drawable.popularity)
        featuresImages.add(R.drawable.socialtree)

        //title
        featuresTitle.add("Search")
        featuresTitle.add("Converting")
        featuresTitle.add("Popularity")
        featuresTitle.add("Sharing")

        //description
        featuresDescription.add("recommendation system ")
        featuresDescription.add("converting images from normal images to creative images")
        featuresDescription.add("predict the popularity of images")
        featuresDescription.add("share in multi-platforms with one click")

        //recyclerView
        binding.rvHomeHorizontal.layoutManager = LinearLayoutManager(requireContext() , LinearLayoutManager.HORIZONTAL , false)
        adapter = HomeAdapter(featuresImages , featuresTitle , featuresDescription , this)
        binding.rvHomeHorizontal.setHasFixedSize(true)
        binding.rvHomeHorizontal.adapter = adapter



    }

    override fun onImageListItemClick(view: View, imagesList: Int) {
        if(imagesList == R.drawable.search)
        {
            Toast.makeText(requireContext(), "search", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }
       else if(imagesList == R.drawable.tamblate) {
            Toast.makeText(requireContext(), "template", Toast.LENGTH_SHORT).show()
        }
        else if(imagesList == R.drawable.popularity) {
            findNavController().navigate(R.id.action_homeFragment_to_predictFragment)
            Toast.makeText(requireContext(), "popularity", Toast.LENGTH_SHORT).show()
        }
        else if(imagesList == R.drawable.socialtree) {
            findNavController().navigate(R.id.action_homeFragment_to_shareFragment)
            Toast.makeText(requireContext(), "share", Toast.LENGTH_SHORT).show()
        }
    }


}