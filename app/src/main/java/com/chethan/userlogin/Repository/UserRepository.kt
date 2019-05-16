package com.chethan.userlogin.Repository

import androidx.lifecycle.LiveData
import com.chethan.userlogin.model.UserInfo

/**
 * Created by Chethan on 5/3/2019.
 */
class UserRepository {

    fun loadUserInfo(): ArrayList<UserInfo> {
        val userInfoList = ArrayList<UserInfo>()
        userInfoList.add(UserInfo("Chethan", "Hulivana", 13, "Eindhovan"))
        userInfoList.add(UserInfo("Chethan", "Hulivana", 13, "Eindhovan"))
        userInfoList.add(UserInfo("Chethan", "Hulivana", 13, "Eindhovan"))
        userInfoList.add(UserInfo("Chethan", "Hulivana", 13, "Eindhovan"))
        return userInfoList
    }
}
