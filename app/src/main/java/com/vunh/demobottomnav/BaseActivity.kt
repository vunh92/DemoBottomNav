package com.vunh.demobottomnav

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {
    private var tag: String = BaseActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

//    fun getOauthToken(): OauthToken? = this.getOauthToken

//    val OauthToken.isValid: Boolean get() = this@BaseActivity.isValidOauthToken

//    fun getAccessToken(): String? {
//        if (getOauthToken()?.isValid == true) {
//            return AppSharePresfs(this).newInstance().getOauthToken()?.access_token
//        } else
//            return null
//    }

    fun startBrowser(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }

    fun showPopup(title: String, message: String, listener: () -> Unit) {
        MaterialAlertDialogBuilder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(getString(R.string.common_ok)) { dialog, _ ->
                listener.invoke()
                dialog.dismiss()
            }
            .setCancelable(false)
            .show()
    }

    fun showYesNoPopup(title: String, message: String, listener: (Boolean) -> Unit) {
        MaterialAlertDialogBuilder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(getString(R.string.common_yes)) { dialog, _ ->
                dialog.dismiss()
                listener.invoke(true)
            }
            .setNegativeButton(getString(R.string.common_no)) { dialog, _ ->
                dialog.dismiss()
                listener.invoke(false)
            }
            .setCancelable(false)
            .show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

}
