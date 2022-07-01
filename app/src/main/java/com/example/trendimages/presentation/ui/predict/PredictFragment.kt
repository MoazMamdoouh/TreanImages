package com.example.trendimages.presentation.ui.predict

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.trendimages.databinding.FragmentPredictBinding
import com.example.trendimages.domain.model.predict.PredictRequest
class PredictFragment : Fragment() {


    private lateinit var binding: FragmentPredictBinding
    private val predictViewModel : PredictViewModel by viewModels()
    private val args :PredictFragmentArgs  by navArgs()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPredictBinding.inflate(inflater)

        binding.predictViewModelObject = predictViewModel
        binding.requestObject = PredictRequest()
        uploadImageFromGallery()
        observeSuccess()
        observeError()
        fetchImage()
        return binding.root
    }

    //take image from search
    private fun fetchImage() {
        val imageSelected = args.image
        binding.imageUrl = imageSelected

    }


    //Upload image from gallery
    private fun uploadImageFromGallery() {
        binding.ivPredictUploadImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 123)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && data != null) {
            val selectImage: Uri? = data.data
            binding.ivPredictUploadImage.setImageURI(selectImage)
            Toast.makeText(requireContext(), "selected image : ${selectImage}", Toast.LENGTH_SHORT).show()

        }
    }




    //observe from viewModel
    private fun observeSuccess()
    {
        predictViewModel.observeSuccess.observe(
            viewLifecycleOwner, Observer {
                binding.tvPredictPredictResult.text = it.message.result.toString()
                Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
            }
        )
    }
    private fun observeError()
    {
        predictViewModel.observeError.observe(
            viewLifecycleOwner, Observer {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
            }
        )
    }


}