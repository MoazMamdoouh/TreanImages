package com.example.trendimages.presentation.ui.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.trendimages.R
import com.example.trendimages.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : FragmentWelcomeBinding = FragmentWelcomeBinding.inflate(inflater)
        onLoginListener(binding)
        onSignUpListener(binding)
        onLoginAsGuestListener(binding)
        return binding.root
    }
    private fun onLoginListener(binding: FragmentWelcomeBinding)
    {
        binding.btWelcomeSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
    }
    private fun onSignUpListener(binding: FragmentWelcomeBinding)
    {
        binding.btWelcomeSignUp.setOnClickListener {
           Toast.makeText(context , "signUp" , Toast.LENGTH_LONG).show()
        }
    }
    private fun onLoginAsGuestListener(binding: FragmentWelcomeBinding)
    {
       //click to go to home
    }


}