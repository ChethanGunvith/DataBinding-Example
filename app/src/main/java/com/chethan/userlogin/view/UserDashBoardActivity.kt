package com.chethan.userlogin.view


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.chethan.userlogin.KEY_ITEM
import com.chethan.userlogin.R
import com.chethan.userlogin.binding.ActivityDataBindingComponent
import com.chethan.userlogin.databinding.UserDashboardActivityBinding
import com.chethan.userlogin.viewmodel.LoginViewModel
import com.chethan.userlogin.viewmodel.LoginViewModelFactory

/**
 * Created by Chethan on 4/21/2019.
 */

class UserDashBoardActivity : AppCompatActivity() {

    private lateinit var userDashBoardDataBinding: UserDashboardActivityBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel = ViewModelProviders.of(this, LoginViewModelFactory()).get(LoginViewModel::class.java);
        userDashBoardDataBinding = DataBindingUtil.setContentView(this, R.layout.user_dashboard_activity)
        userDashBoardDataBinding.loginViewModel = loginViewModel

        var dataBindingComponent: DataBindingComponent = ActivityDataBindingComponent(this)
        val dataAdapter = DataAdapter(dataBindingComponent) {
            userInfo ->



        }

        userDashBoardDataBinding.userDetailList.adapter = dataAdapter
        postponeEnterTransition()

        userDashBoardDataBinding.userDetailList.getViewTreeObserver()
            .addOnPreDrawListener {
                startPostponedEnterTransition()
                true
            }
        initContributorList(loginViewModel)

    }


    private fun initContributorList(viewModel: LoginViewModel) {
        loginViewModel.observe(viewLifecycleOwner, Observer { listResource ->
            // we don't need any null checks here for the adapter since LiveData guarantees that
            // it won't call us if fragment is stopped or not started.
            if (listResource?.data != null) {
                adapter.submitList(listResource.data)
            } else {
                adapter.submitList(emptyList())
            }
        })
    }
}