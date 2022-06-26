package com.example.trendimages.presentation.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.trendimages.R
import com.example.trendimages.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

       binding = FragmentWelcomeBinding.inflate(inflater)
        loginClickedListener()
        createAccountClickedListener()
        guestClickedListener()
        return binding.root
    }
    private fun loginClickedListener()
    {
        binding.btWelcomeSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
    }
    private fun createAccountClickedListener()
    {
        binding.btWelcomeSignUp.setOnClickListener {
            Toast.makeText(requireContext(), "create account clicked", Toast.LENGTH_LONG).show()
        }
    }
    private fun guestClickedListener()
    {
        binding.tvWelcomeGuest.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_homeFragment)
        }
    }

}