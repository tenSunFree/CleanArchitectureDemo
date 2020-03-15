package com.home.cleanarchitecturedemo.common.extension

import com.home.cleanarchitecturedemo.common.base.BaseViewModel
import io.reactivex.disposables.Disposable

fun Disposable.add(viewModel: BaseViewModel) {
    viewModel.addDisposable(this)
}