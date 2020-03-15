package com.home.data.common.di

import com.home.data.remote.api.MainApi
import com.home.data.remote.builder.RetrofitBuilder
import com.home.data.remote.interceptor.HeaderInterceptor
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        retrofitBuilder: RetrofitBuilder,
        headerInterceptor: HeaderInterceptor
    ): Retrofit = retrofitBuilder
        .setBaseURL("https://jsonplaceholder.typicode.com/")
        .addInterceptors(headerInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideMainApi(retrofit: Retrofit): MainApi = retrofit.create(MainApi::class.java)
}