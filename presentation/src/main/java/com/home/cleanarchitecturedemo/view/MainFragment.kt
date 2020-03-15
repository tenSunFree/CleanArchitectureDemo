package com.home.cleanarchitecturedemo.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.home.cleanarchitecturedemo.BR
import com.home.cleanarchitecturedemo.R
import com.home.cleanarchitecturedemo.common.base.BaseFragment
import com.home.cleanarchitecturedemo.common.binding.FragmentDataBindingComponent
import com.home.cleanarchitecturedemo.common.extension.toast
import com.home.cleanarchitecturedemo.common.util.autoCleared
import com.home.cleanarchitecturedemo.databinding.FragmentMainBinding
import com.home.cleanarchitecturedemo.viewmodel.MainViewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {

    override val bindingVariable: Int get() = BR.viewModel
    override val layoutId: Int get() = R.layout.fragment_main
    override val viewModel: MainViewModel by viewModels { viewModelFactory }
    private var adapter by autoCleared<MainFragmentAdapter>()
    private var bindingComponent = FragmentDataBindingComponent(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        subscribeView()
    }

    private fun subscribeView() = with(viewModel) {
        response.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        loading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
        getData()
    }

    private fun setAdapter() {
        this.adapter = MainFragmentAdapter(bindingComponent) {
            context?.toast("click item")
        }
        with(binding) {
            recyclerView.adapter = adapter
        }
    }
}
