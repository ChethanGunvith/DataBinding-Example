package com.chethan.userlogin.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.chethan.userlogin.viewmodel.EmailValidation
import com.chethan.userlogin.viewmodel.PasswordValidation

/**
 * A Binding Adapter that is called whenever the value of the attribute `app:popularityIcon`
 * changes. Receives a popularity level that determines the icon and tint color to use.
 */
@BindingAdapter("app:emailValidation")
fun emailValidation(view: TextView, emailValidation: EmailValidation) {
    view.setText(getErrorString(emailValidation))
}

private fun getErrorString(emailValidation: EmailValidation): String {
    return when (emailValidation) {
        EmailValidation.NORMAL -> {
            ""
        }

        EmailValidation.EMPTY_EMAIL -> {
            "Please provide your email ID"
        }
        EmailValidation.INVALID_EMAIL -> {
            "Please provide valid Email ID"
        }
    }
}


@BindingAdapter("app:passwordValidation")
fun passwordValidation(view: TextView, passwordValidation: PasswordValidation) {
    view.setText(getPasswordValidationErrorString(passwordValidation))
}

private fun getPasswordValidationErrorString(passwordValidation: PasswordValidation): String {
    return when (passwordValidation) {
        PasswordValidation.NORMAL -> {
            ""
        }
        PasswordValidation.EMPTY_PASSWORD -> {
            "Please provide valid password"
        }
        PasswordValidation.INVALID_PASSWORD -> {
            "Please provide atleast 5 character"
        }
    }
}


