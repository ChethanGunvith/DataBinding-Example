package com.chethan.userlogin.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.chethan.userlogin.KEY_ITEM
import com.chethan.userlogin.R
import com.chethan.userlogin.databinding.UserDashboardActivityBinding
import com.chethan.userlogin.model.UserLogin
import com.chethan.userlogin.viewmodel.LoginViewModel

/**
 * Created by Chethan on 4/21/2019.
 */

class UserDashBoardActivity : AppCompatActivity() {

    private lateinit var userDashBoardDataBinding: UserDashboardActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userLogin = getIntent().getExtras().getSerializable(KEY_ITEM) as UserLogin
        val userEmailAddress: String = userLogin.stringUserEmail
        val userPassword: String = userLogin.stringUserPassword
        userDashBoardDataBinding = DataBindingUtil.setContentView(this, R.layout.user_dashboard_activity)
        userDashBoardDataBinding.lbUserLoginId.setText(userEmailAddress)
        userDashBoardDataBinding.lbUserPasswordInfo.setText(userPassword)


    }
}