/*
 * Copyright (c) 2021 Sergio Aragonés. All rights reserved.
 * Created by Sergio Aragonés on 29/5/2021
 */

package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)

        with(binding) {
            buttonLogin.setOnClickListener(
                Navigation.createNavigateOnClickListener(
                    LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
                )
            )
            buttonRegister.setOnClickListener(
                Navigation.createNavigateOnClickListener(
                    LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
                )
            )
        }

        return binding.root
    }
}