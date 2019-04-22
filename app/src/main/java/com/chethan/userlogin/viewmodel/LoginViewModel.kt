package com.chethan.userlogin.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.view.View
import com.chethan.userlogin.model.UserLogin

/**
 * Created by Chethan on 4/19/2019.
 */
class LoginViewModel : ViewModel() {


    var userName = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var userMutableLiveData: MutableLiveData<UserLogin>? = null
    val userLogin: MutableLiveData<UserLogin>
        get() {

            if (userMutableLiveData == null) {
                userMutableLiveData = MutableLiveData()
            }
            return userMutableLiveData as MutableLiveData<UserLogin>
        }


    fun onClickOfLogin(v: View) {

        if (userName.value != null && password.value != null) {
            val userLogin = UserLogin(userName?.value!!, password?.value!!)
            userMutableLiveData!!.value = userLogin
        }
    }

}