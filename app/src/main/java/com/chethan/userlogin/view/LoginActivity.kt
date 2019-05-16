package com.chethan.userlogin.view


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.chethan.userlogin.R
import com.chethan.userlogin.common.LoginCallBack
import com.chethan.userlogin.databinding.ActivityMainBinding
import com.chethan.userlogin.viewmodel.LoginViewModel
import com.chethan.userlogin.viewmodel.LoginViewModelFactory

/**
 * Created by Chethan on 4/19/2019.
 */

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel = ViewModelProviders.of(this, LoginViewModelFactory()).get(LoginViewModel::class.java);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.loginViewModel = loginViewModel
        binding.lifecycleOwner = this
        binding.callback = object : LoginCallBack {
            override fun isValidLogin() {
                if (loginViewModel.isValidLogin()) {
                    val i = Intent(this@LoginActivity, UserDashBoardActivity::class.java)
                    startActivity(i)
                }
            }
        }


    }

}
