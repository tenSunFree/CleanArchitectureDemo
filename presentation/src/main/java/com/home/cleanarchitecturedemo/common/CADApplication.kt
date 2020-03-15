package com.home.cleanarchitecturedemo.common

import com.home.cleanarchitecturedemo.common.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class CADApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<CADApplication> =
        DaggerAppComponent.factory().create(this)
}