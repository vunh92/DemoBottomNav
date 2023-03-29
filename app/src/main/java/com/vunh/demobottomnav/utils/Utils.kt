package com.vunh.demobottomnav.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.provider.Settings
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.inputmethod.InputMethodManager
import java.util.*


class Utils {
    companion object {

        fun setAnimationClickItem(view: View, duration: Long = 1000) {
            val animation: Animation = AlphaAnimation(0.3f, 1.0f)
            animation.duration = duration
            view.startAnimation(animation)
        }

        @SuppressLint("HardwareIds")
        fun getDeviceId(context: Context): String {
            return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        }

        fun getWidthScreen(marginHorizontal: Int = 0): Int {
            return Resources.getSystem().displayMetrics.widthPixels - marginHorizontal
        }

        fun getHeightScreen(marginVertical: Int = 0) = Resources.getSystem().displayMetrics.widthPixels - marginVertical

        fun Context.hideKeyboard(view: View?) {
            val inputMethodManager = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
        }


        fun Context.isNetworkAvailable(): Boolean {
            val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val nw = connectivityManager.activeNetwork ?: return false
            val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
            return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                //for other device how are able to connect with Ethernet
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                //for check internet over Bluetooth
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
                else -> false
            }
        }
    }
}
