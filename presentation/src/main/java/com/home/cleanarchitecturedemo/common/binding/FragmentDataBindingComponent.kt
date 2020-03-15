package com.home.cleanarchitecturedemo.common.binding

import androidx.databinding.DataBindingComponent
import androidx.fragment.app.Fragment

class FragmentDataBindingComponent(fragment: Fragment) : DataBindingComponent {

    private val adapter = FragmentBindingAdapters(fragment)

    fun getFragmentBindingAdapters() = adapter
}
