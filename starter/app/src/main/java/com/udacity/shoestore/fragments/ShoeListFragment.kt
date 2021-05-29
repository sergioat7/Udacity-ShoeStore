/*
 * Copyright (c) 2021 Sergio Aragonés. All rights reserved.
 * Created by Sergio Aragonés on 29/5/2021
 */

package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.udacity.shoestore.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance() = ShoeListFragment()
    }
}