package com.kotlin.base.ui.activity

import  com.kotlin.base.injection.component.ActivityComponent
import android.os.Bundle
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.injection.module.LifecycleProviderModule
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.ui.fragment.BaseFragment
import com.kotlin.base.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject


open abstract class BaseMvpActivity<T:BasePresenter<*>>: BaseActivity(),BaseView{
        lateinit var  activityComponent:ActivityComponent
    lateinit var  mLoadingDialog :ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()
        mLoadingDialog = ProgressLoading.create(this)
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
        mLoadingDialog.showLoading()
    }

    override fun hideLoading() {
        mLoadingDialog.dismiss()
    }

    override fun onError(error:String) {
        toast(error)
    }
    @Inject
    lateinit var  mPresenter: T
}