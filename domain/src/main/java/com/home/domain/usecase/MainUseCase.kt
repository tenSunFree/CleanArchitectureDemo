package com.home.domain.usecase

import com.home.domain.model.Main
import com.home.domain.repository.MainRepository
import io.reactivex.Single
import javax.inject.Inject

open class MainUseCase @Inject constructor(
    private val repository: MainRepository
) : UseCase<MainUseCase.Params, Single<List<Main>>>() {

    override fun createObservable(params: Params?): Single<List<Main>> {
        return repository.getData()
    }

    override fun onCleared() {}

    data class Params(val query: String, val pageNumber: Int? = 1)
}