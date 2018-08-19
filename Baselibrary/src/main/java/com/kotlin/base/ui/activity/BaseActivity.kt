package com.kotlin.base.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.kotlin.base.common.APPManger
import com.trello.rxlifecycle.components.support.RxAppCompatActivity


open class  BaseActivity:RxAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        APPManger.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        APPManger.instance.finishActivity(this)
    }

}