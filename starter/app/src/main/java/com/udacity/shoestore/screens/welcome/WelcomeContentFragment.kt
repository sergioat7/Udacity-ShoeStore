/*
 * Copyright (c) 2021 Sergio Aragonés. All rights reserved.
 * Created by Sergio Aragonés on 5/6/2021
 */

package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeContentBinding

class WelcomeContentFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeContentBinding

    companion object {
        const val ARG_OBJECT = "position"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_welcome_content, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {

            val position = getInt(ARG_OBJECT)
            val imageId = if (position == 0) R.drawable.welcome else R.drawable.shoes_2
            val titleId = if (position == 0) R.string.welcomeTitle1 else R.string.welcomeTitle2
            with(binding) {
                image = ResourcesCompat.getDrawable(resources, imageId, null)
                title = getString(titleId)
            }
        }
    }
}