package com.home.data.remote.api

import com.home.data.model.MainEntity
import io.reactivex.Single
import retrofit2.http.GET

interface MainApi {
    
    @GET("comments")
    fun getData(): Single<List<MainEntity>>
}