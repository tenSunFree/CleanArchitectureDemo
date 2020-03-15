package com.home.data.repositoryimpl

import com.home.data.model.MainEntityMapper
import com.home.data.remote.api.MainApi
import com.home.domain.model.Main
import com.home.domain.repository.MainRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepositoryImpl @Inject constructor(
    private val api: MainApi,
    private val mapper: MainEntityMapper
) : MainRepository {

    override fun getData(): Single<List<Main>> {
        return api.getData()
            .map { response ->
                response.map {
                    mapper.mapToDomain(it)
                }
            }
            .doOnError { Throwable("Not found!") }
    }
}