package com.kotlin.user.injection.component

import android.support.v7.app.AppCompatActivity
import com.kotlin.base.injection.ActivityScope
import com.kotlin.base.injection.PerPerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.component.AppComponent
import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.ui.activity.RegisterActivity
import dagger.Component
@PerPerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class), modules = arrayOf(UserModule::class))
interface UserComponent {
    fun  inject(activity:RegisterActivity)
}