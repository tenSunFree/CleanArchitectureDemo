package com.home.cleanarchitecturedemo.viewmodel

import androidx.lifecycle.MutableLiveData
import com.home.cleanarchitecturedemo.common.base.BaseViewModel
import com.home.cleanarchitecturedemo.common.extension.add
import com.home.cleanarchitecturedemo.common.util.RxUtils
import com.home.cleanarchitecturedemo.model.MainItem
import com.home.cleanarchitecturedemo.model.MainItemMapper
import com.home.domain.usecase.MainUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val useCase: MainUseCase,
    private val mapper: MainItemMapper
) : BaseViewModel() {

    val response = MutableLiveData<List<MainItem>>()
    val loading =
        MutableLiveData<Boolean>().apply {
            postValue(false)
        }

    fun getData() {
        useCase.createObservable()
            .compose(RxUtils.applySingleScheduler(loading))
            .doFinally { loading.value = false }
            .map { it ->
                it.map { mapper.mapToPresentation(it) }
            }
            .subscribe({
                response.value = it
            }, {
                setThrowable(it)
            })
            .add(this)
    }
}