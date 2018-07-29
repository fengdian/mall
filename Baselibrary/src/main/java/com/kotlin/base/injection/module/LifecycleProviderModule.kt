package com.kotlin.base.injection.module

import android.app.Activity
import android.content.Context
import com.kotlin.base.common.BaseApplication
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LifecycleProviderModule (private val  lifecycleProvide:LifecycleProvider<*>){
    @Provides
    fun  providesLifecycleProvider():LifecycleProvider<*>{
        return  lifecycleProvide
    }
}