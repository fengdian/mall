package com.kotlin.user.presenter

import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.user.presenter.view.RegisterView
import com.kotlin.user.service.UserService
import com.kotlin.user.service.impl.UserServiceImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber


class RegisterPresenter :BasePresenter<RegisterView>() {
    fun register(mobile:String,verifyCode:String,pwd:String){
        /**
         * 业务逻辑
         */
        val userService = UserServiceImpl()
        userService.register(mobile,verifyCode,pwd )
                .observeOn(AndroidSchedulers.mainThread() )
                .subscribeOn(Schedulers.io())

               /* .subscribe(object :Subscriber<Boolean>(){

                })*/
                .subscribe(object: rx.Subscriber<Boolean>(){
                    override fun onNext(t: Boolean?) {
                        mView.onRegisterResult(t)

                    }

                    override fun onCompleted() {

                    }

                    override fun onError(e: Throwable?) {
                    }
                })
      //  mView.onRegisterResult(true);
    }
}