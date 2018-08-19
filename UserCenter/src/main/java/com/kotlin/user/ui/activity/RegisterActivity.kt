package com.kotlin.user.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.base.widgets.VerifyButton
import com.kotlin.user.R
import com.kotlin.user.injection.component.DaggerUserComponent
import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.presenter.RegisterPresenter
import com.kotlin.user.presenter.view.RegisterView
import dagger.internal.DaggerCollections
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>() , RegisterView {
    override fun onRegisterResult(result: String ) {

            toast(result)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
     /*   mPresenter = RegisterPresenter()*/

        mRegisterBtn.setOnClickListener{
            mPresenter.register(mMoblieEt.text.toString(),mVerifyCodeEt.text.toString(),mPwdEt.text.toString())
           //toast("注册");
           // Toast.makeText(this,"注册",Toast.LENGTH_LONG).show();
           // startActivity<TestActivity>();
          //  startActivity(intentFor<TestActivity>("id" to 5).singleTop())
          //  startActivity<TestActivity>( "id" to 10)
            mGetVerifyCodeBtn.setOnVerifyBtnClick(object:VerifyButton.OnVerifyBtnClick{
                override fun onClick() {
                    toast("获取验证码")
                }

            })
            mGetVerifyCodeBtn.onClick {
                mGetVerifyCodeBtn.requestSendVerifyNumber()
            }


        }
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        //DaggerUserComponent.builder().userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onError(error: String) {
        toast(error)
    }
}
