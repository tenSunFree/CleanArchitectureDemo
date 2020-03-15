package com.home.cleanarchitecturedemo.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.home.cleanarchitecturedemo.R
import com.home.cleanarchitecturedemo.common.base.BaseRecyclerAdapter
import com.home.cleanarchitecturedemo.databinding.FragmentMainItemBinding
import com.home.cleanarchitecturedemo.model.MainItem

class MainFragmentAdapter(
    private val dataBindingComponent: DataBindingComponent,
    private val callback: ((MainItem) -> Unit)?
) : BaseRecyclerAdapter<MainItem>(

    callBack = object : DiffUtil.ItemCallback<MainItem>() {
        override fun areItemsTheSame(oldItem: MainItem, newItem: MainItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MainItem, newItem: MainItem): Boolean {
            return oldItem.name == newItem.name && oldItem.id == newItem.id
        }
    }) {

    override fun createBinding(parent: ViewGroup, viewType: Int?): ViewDataBinding =
        DataBindingUtil.inflate<FragmentMainItemBinding>(
            LayoutInflater.from(parent.context), R.layout.fragment_main_item,
            parent, false, dataBindingComponent
        ).apply {
            root.setOnClickListener {
                this.item?.let { item ->
                    callback?.invoke(item)
                }
            }
        }

    override fun bind(binding: ViewDataBinding, item: MainItem) {
        if (binding is FragmentMainItemBinding) binding.item = item
    }
}
