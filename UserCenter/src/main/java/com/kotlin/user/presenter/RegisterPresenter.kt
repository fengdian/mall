package com.kotlin.user.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.presenter.view.RegisterView
import com.kotlin.user.service.UserService
import com.kotlin.user.service.impl.UserServiceImpl
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject


class RegisterPresenter @Inject constructor():BasePresenter<RegisterView>() {
    @Inject
    lateinit var userService:UserServiceImpl
    //注册
    fun register(mobile:String,verifyCode:String,pwd:String){
        /**
         * 业务逻辑
         */
        userService.register(mobile,verifyCode,pwd ).execute(object:BaseSubscriber<Boolean>(){
            override fun onNext(t: Boolean) {
                if(t)
                      mView.onRegisterResult("注册成功")
                else
                    mView.onRegisterResult("注册失败")
            }
        },lifecycleProvider)

      //  mView.onRegisterResult(true);
    }
    //登录
  /*  fun login(mobile:String,pwd:String){
        *//**
         * 业务逻辑
         *//*
        val userService = UserServiceImpl()
        userService.register(mobile,verifyCode,pwd )
                .observeOn(AndroidSchedulers.mainThread()  )
                .subscribeOn(Schedulers.io())
                .subscribe(object: rx.Subscriber<Boolean>(){
                    override fun onNext(t: Boolean) {
                        mView.onRegisterResult(t)

                    }

                    override fun onCompleted() {

                    }

                    override fun onError(e: Throwable?) {
                    }
                })
        //  mView.onRegisterResult(true);
    }*/
}