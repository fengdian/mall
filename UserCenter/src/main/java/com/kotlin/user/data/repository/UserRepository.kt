package com.kotlin.user.data.repository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.data.api.UserApi
import com.kotlin.user.data.protocol.RegisterReq
import rx.Observable
import javax.inject.Inject

class UserRepository @Inject constructor() {
   fun register(mobile: String, verifyCode: String, pwd: String): Observable<BaseResp<String>> {
        return  RetrofitFactory.instance.create(UserApi::class.java)
                  .register(RegisterReq(mobile,pwd,verifyCode))
   }
}