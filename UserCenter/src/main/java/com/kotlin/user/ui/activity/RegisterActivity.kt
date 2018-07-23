package com.kotlin.user.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.user.R
import com.kotlin.user.presenter.RegisterPresenter
import com.kotlin.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>() ,RegisterView{
    override fun onRegisterResult(result: Boolean) {
        toast("注册成功")
      //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mPresenter = RegisterPresenter()
        mPresenter.mView = this;
        mRegisterBtn.setOnClickListener{
            mPresenter.register("15539922841","1234")
           //toast("注册");
           // Toast.makeText(this,"注册",Toast.LENGTH_LONG).show();
           // startActivity<TestActivity>();
          //  startActivity(intentFor<TestActivity>("id" to 5).singleTop())
          //  startActivity<TestActivity>( "id" to 10)

        }
    }


    }
