package com.chethan.userlogin.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import com.chethan.userlogin.KEY_ITEM
import com.chethan.userlogin.R
import com.chethan.userlogin.databinding.ActivityMainBinding
import com.chethan.userlogin.viewmodel.LoginViewModel

/**
 * Created by Chethan on 4/19/2019.
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.loginViewModel = loginViewModel

        loginViewModel!!.userLogin.observe(this, Observer { result ->

            if (TextUtils.isEmpty(result?.stringUserPassword)) {
                binding.txtEmailAddress.error = "Enter an E-Mail Address"
                binding.txtEmailAddress.requestFocus()
            } else if (!result!!.isEmailValid) {
                binding.txtEmailAddress.error = "Enter an E-Mail Address"
                binding.txtEmailAddress.requestFocus()
            } else if (TextUtils.isEmpty(result?.stringUserPassword)) {
                binding.txtPassword.error = "Password is empty"
                binding.txtPassword.requestFocus()
            } else if (!result!!.isPasswordLengthGreaterThan5) {
                binding.txtPassword.error = "Please set five digit password"
                binding.txtPassword.requestFocus()
            } else {

                val i = Intent(this, UserDashBoardActivity::class.java)
                val bundle = Bundle();
                bundle.putSerializable(KEY_ITEM, result)
                i.putExtras(bundle)
                startActivity(i)
            }


        })


    }

}
