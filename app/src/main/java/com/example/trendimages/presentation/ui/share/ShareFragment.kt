package com.example.trendimages.presentation.ui.share

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.trendimages.R
import com.example.trendimages.databinding.FragmentShareBinding

class ShareFragment : Fragment() {
 private lateinit var binding : FragmentShareBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentShareBinding.inflate(inflater)
         uploadImageFromGallery()
        return binding.root
    }
    //Upload image from gallery
    private fun uploadImageFromGallery() {
        binding.ivShareUploadImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 123)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && data != null) {
            val selectImage: Uri? = data.data
            binding.ivShareUploadImage.setImageURI(selectImage)
            Toast.makeText(requireContext(), "selected image : ${selectImage}", Toast.LENGTH_SHORT).show()
            shareImage(selectImage)
        }
    }
    //share image
    private fun shareImage(uri : Uri?)
    {
        binding.btShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_STREAM , uri)
            val chooser = Intent.createChooser(intent,"share using ")
            startActivity(chooser)
        }
    }

}