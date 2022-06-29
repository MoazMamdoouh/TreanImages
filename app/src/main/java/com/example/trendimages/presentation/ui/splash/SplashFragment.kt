package com.example.trendimages.presentation.ui.splash


import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.trendimages.R
import com.example.trendimages.databinding.FragmentSplashBinding
import com.example.trendimages.presentation.ui.login.PrefManger

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
   private  lateinit var pref: PrefManger

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater)
        timer()
        return binding.root
    }

    private fun timer() {
        pref = PrefManger(requireContext())
        val SPLASH_TIME: Long = 3000
        if (pref.isLogin() == true) {
            Handler().postDelayed({
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            }, SPLASH_TIME)
        } else {
            pref.setLogin(true)
            Handler().postDelayed({
                findNavController().navigate(R.id.action_splashFragment_to_welcomeFragment)
            }, SPLASH_TIME)
        }
    }
}

