package com.home.cleanarchitecturedemo.common.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.home.domain.exception.*
import com.home.domain.model.Dialog
import com.home.domain.model.Redirect
import com.home.domain.model.Tag
import com.home.domain.usecase.UseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel constructor(
    private vararg val useCases: UseCase<*, *>?
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val snackBarMessage = MutableLiveData<String>()
    val toastMessage = MutableLiveData<String>()
    val inlineException = MutableLiveData<List<Tag>>()
    val alertException = MutableLiveData<Pair<String?, String>>()
    val dialogException = MutableLiveData<Dialog>()
    val redirectException = MutableLiveData<Redirect>()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun setThrowable(throwable: Throwable) {
        when (throwable) {
            is SnackBarException -> { snackBarMessage.value = throwable.message }
            is ToastException -> toastMessage.value = throwable.message
            is InlineException -> inlineException.value = throwable.tags.toList()
            is AlertException -> alertException.value = Pair(throwable.title, throwable.message)
            is DialogException -> dialogException.value = throwable.dialog
            is RedirectException -> redirectException.value = throwable.redirect
        }
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        useCases.let { userCases ->
            if (userCases.isNotEmpty()) userCases.forEach { it?.onCleared() }
        }
        super.onCleared()
    }
}
