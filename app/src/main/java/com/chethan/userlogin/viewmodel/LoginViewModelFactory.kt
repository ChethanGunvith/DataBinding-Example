package com.chethan.userlogin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by Chethan on 4/26/2019.
 */

class LoginViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {


        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            val KEY = "USER_INFO_VIEW_MODEL"
            if (hashMapViewModel.containsKey(KEY)) {
                return getViewModel(KEY) as T
            } else {
                addViewModel(KEY, LoginViewModel())
                return getViewModel(KEY) as T
            }
        }

        throw IllegalArgumentException(" Unknown view model class")
    }

    companion object {
        val hashMapViewModel = HashMap<String, ViewModel>()

        fun addViewModel(key: String, viewModel: ViewModel) {
            hashMapViewModel.put(key, viewModel)
        }

        fun getViewModel(key: String): ViewModel? {
            return hashMapViewModel[key]
        }
    }

}