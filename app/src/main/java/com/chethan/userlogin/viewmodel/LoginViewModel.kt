package com.chethan.userlogin.viewmodel


import android.text.TextUtils
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.chethan.userlogin.Repository.UserRepository
import com.chethan.userlogin.model.UserInfo

/**
 * Created by Chethan on 4/19/2019.
 */
class LoginViewModel constructor(repository: UserRepository) : ViewModel() {

    var email = MutableLiveData<String>("")
    var password = MutableLiveData<String>("")

    private val _userInfo: MutableLiveData<UserInfo> = MutableLiveData()
    val userInfo: LiveData<UserInfo>
        get() = _userInfo

    val passValidation: LiveData<PasswordValidation> = Transformations.map(password) {
        System.out.println(password.value.toString().length)
        when {
            TextUtils.isEmpty(password.value) -> PasswordValidation.EMPTY_PASSWORD
            isInValidPassword() -> PasswordValidation.INVALID_PASSWORD
            else -> PasswordValidation.NORMAL

        }
    }


    val userInfoList: LiveData<List<UserInfo>> = Transformations
        .switchMap(_userInfo) { input ->
            input.ifExists { owner, name ->
                repository.loadContributors(owner, name)
            }
        }



    val emailValidation: LiveData<EmailValidation> = Transformations.map(email) {
        when {
            TextUtils.isEmpty(email.value) -> EmailValidation.EMPTY_EMAIL
            !isValidEmailAddress() -> EmailValidation.INVALID_EMAIL
            else -> EmailValidation.NORMAL
        }
    }

    private fun isInValidPassword() : Boolean {
        return password.value.toString().length < 5
    }

    private fun isValidEmailAddress(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email.value.toString()).matches()
    }

    fun isValidLogin() : Boolean {
        return isValidEmailAddress() && !isInValidPassword()
    }


    data class UserId(val owner: String, val name: String) {
        fun <T> ifExists(f: (String, String) -> LiveData<T>): LiveData<T> {
            return if (owner.isBlank() || name.isBlank()) {
                AbsentLiveData.create()
            } else {
                f(owner, name)
            }
        }
    }
}




enum class PasswordValidation {
    NORMAL,
    EMPTY_PASSWORD,
    INVALID_PASSWORD,

}

enum class EmailValidation {
    NORMAL,
    EMPTY_EMAIL,
    INVALID_EMAIL,

}