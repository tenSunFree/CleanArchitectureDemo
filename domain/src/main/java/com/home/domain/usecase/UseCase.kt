package com.home.domain.usecase

abstract class UseCase<in Params, out T> where T : Any {

    abstract fun createObservable(params: Params? = null): T

    open fun onCleared() {}
}