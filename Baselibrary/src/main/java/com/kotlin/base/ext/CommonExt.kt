package com.kotlin.base.ext

import com.kotlin.base.rx.BaseSubscriber
import com.trello.rxlifecycle.LifecycleProvider

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

fun <T>Observable<T>.execute(subscriber: BaseSubscriber<T>,lifecycleProvider: LifecycleProvider<*>){
     this.observeOn(AndroidSchedulers.mainThread())
             .compose(lifecycleProvider.bindToLifecycle())
            .subscribeOn(Schedulers.io())
            .subscribe(subscriber)



}