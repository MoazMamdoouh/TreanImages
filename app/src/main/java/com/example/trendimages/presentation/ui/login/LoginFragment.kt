package com.example.trendimages.presentation.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.trendimages.R
import com.example.trendimages.databinding.FragmentLoginBinding
import com.example.trendimages.domain.model.LoginRequest
import java.util.*

class LoginFragment : Fragment() {
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentLoginBinding = FragmentLoginBinding.inflate(inflater)
        binding.loginObject = LoginRequest()
        binding.loginListener = loginViewModel

        observeLoginData()
        observeError()
        return binding.root
    }

    private fun observeLoginData() {
        loginViewModel.observeLoginSuccess.observe(
            viewLifecycleOwner, androidx.lifecycle.Observer {
             Toast.makeText(context , "success" , Toast.LENGTH_LONG).show()
            })

    }
    private fun observeError()
    {
        loginViewModel.observeLoginError.observe(
            viewLifecycleOwner, androidx.lifecycle.Observer {
                Toast.makeText(context , "error" , Toast.LENGTH_LONG).show()
            }
        )
    }

}