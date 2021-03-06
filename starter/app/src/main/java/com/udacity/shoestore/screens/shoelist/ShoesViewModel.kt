/*
 * Copyright (c) 2021 Sergio Aragonés. All rights reserved.
 * Created by Sergio Aragonés on 6/6/2021
 */

package com.udacity.shoestore.screens.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesViewModel : ViewModel() {

    private var _shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())

    val shoes: LiveData<MutableList<Shoe>> = _shoes

    fun addShoe(shoe: Shoe) {
        _shoes.value?.add(shoe)
    }
}