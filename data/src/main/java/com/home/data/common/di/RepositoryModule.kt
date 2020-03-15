package com.home.data.common.di

import com.home.data.repositoryimpl.MainRepositoryImpl
import com.home.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providerItemRepository(repository: MainRepositoryImpl): MainRepository {
        return repository
    }
}
