package com.home.cleanarchitecturedemo.common.di.builder

import com.home.cleanarchitecturedemo.view.MainActivity
import com.home.cleanarchitecturedemo.view.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment
}
