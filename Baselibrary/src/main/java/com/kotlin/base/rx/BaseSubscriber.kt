package com.kotlin.base.rx

import android.widget.ActionMenuView
import com.kotlin.base.presenter.view.BaseView
import rx.Subscriber

open class BaseSubscriber<T>(val  baseView :BaseView) :Subscriber<T>() {
    override fun onNext(t: T) {

    }

    override fun onCompleted() {
        baseView.hideLoading()
    }


    override fun onError(e: Throwable?) {
        baseView.hideLoading()
    }
}