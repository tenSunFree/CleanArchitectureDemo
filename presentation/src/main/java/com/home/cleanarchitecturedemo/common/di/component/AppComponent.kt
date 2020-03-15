package com.home.cleanarchitecturedemo.common.di.component

import com.home.cleanarchitecturedemo.common.CADApplication
import com.home.cleanarchitecturedemo.common.di.builder.AppModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class])
interface AppComponent : AndroidInjector<CADApplication> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<CADApplication>
}