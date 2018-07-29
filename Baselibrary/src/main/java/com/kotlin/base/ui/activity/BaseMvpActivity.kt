package com.kotlin.base.ui.activity

import  com.kotlin.base.injection.component.ActivityComponent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.injection.module.LifecycleProviderModule
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import org.jetbrains.anko.activityManager
import javax.inject.Inject


open abstract class BaseMvpActivity<T:BasePresenter<*>>:BaseActivity(),BaseView{
        lateinit var  activityComponent:ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()
    }
    abstract  fun injectComponent()
    private fun initActivityInjection() {
      activityComponent=  DaggerActivityComponent.builder()
              .appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
              .lifecycleProviderModule(LifecycleProviderModule(this))
              .build();
        println("------------initActivityInjection -end")

     }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError() {
    }
    @Inject
    lateinit var  mPresenter: T
}