package com.chethan.userlogin.model

import android.util.Patterns
import java.io.Serializable

/**
 * Created by Chethan on 4/19/2019.
 */
class UserLogin(var stringUserEmail: String, var stringUserPassword: String) : Serializable {


    val isEmailValid: Boolean
        get() = Patterns.EMAIL_ADDRESS.matcher(stringUserEmail).matches()


    val isPasswordLengthGreaterThan5: Boolean
        get() = stringUserPassword.length > 5
}