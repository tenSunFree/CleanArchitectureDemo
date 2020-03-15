package com.home.cleanarchitecturedemo.common.di.builder

import android.content.Context
import com.home.cleanarchitecturedemo.common.CADApplication
import com.home.data.common.di.NetworkModule
import com.home.data.common.di.RepositoryModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [ViewModelModule::class, FragmentBuildersModule::class,
        NetworkModule::class, RepositoryModule::class]
)
class AppModule {

    @Singleton
    @Provides
    fun providerContext(application: CADApplication): Context {
        return application.applicationContext
    }
}