package com.fictivestudios.ravebae.utils

class Constants {
    companion object {

        const val IS_USER = "is_user"

        var isAccountLogin = false
        var loginType:String? =null
       const val EMAIL = "email"
        const val PHONE ="phone"

        fun isValidEmail(str: String): Boolean{
            return android.util.Patterns.EMAIL_ADDRESS.matcher(str).matches()
        }
    }
}