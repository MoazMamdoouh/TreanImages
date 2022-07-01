package com.example.trendimages.presentation.ui.search


import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.trendimages.databinding.FragmentSearchBinding
import com.example.trendimages.domain.model.search.SearchRequest
import com.example.trendimages.domain.model.search.SearchResponse


class SearchFragment : Fragment(), SearchOnClickListener {
    private val searchViewModel: SearchViewModel by viewModels()
    private lateinit var searchAdapter: SearchAdapter
    private lateinit var binding: FragmentSearchBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentSearchBinding.inflate(inflater, container, false)
        binding.searchRequestObject = SearchRequest()
        binding.searchRequestListner = searchViewModel


        observeSearchSuccess()
        observeSearchError()
        return binding.root

    }

    private fun observeSearchSuccess() {
        searchViewModel.observeSearchSuccess.observe(
            viewLifecycleOwner, Observer {
                Toast.makeText(context, "success", Toast.LENGTH_LONG).show()
                initializeImageList(it)
            }
        )
    }

    private fun observeSearchError() {
        searchViewModel.observeSearchError.observe(
            viewLifecycleOwner, Observer {
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
            }
        )
    }

    private fun initializeImageList(searchImage: SearchResponse) {
        binding.rvSearch.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.rvSearch.setHasFixedSize(true)
        searchAdapter = SearchAdapter(searchImage, this)
        binding.rvSearch.adapter = searchAdapter

    }

    override fun onImageListItemClick(view: View, imagesList: String) {
        val request = DownloadManager.Request(Uri.parse(imagesList))
            .setTitle("TrendImage")
            .setDescription("Downloading...")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setAllowedOverMetered(true)
        val dm = activity?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        dm.enqueue(request)
        Toast.makeText(requireContext(), "Downloading...", Toast.LENGTH_SHORT).show()

        //send image to the predict fragment
        val action = SearchFragmentDirections.actionSearchFragmentToPredictFragment(imagesList)
        Navigation.findNavController(view).navigate(action)
    }

}