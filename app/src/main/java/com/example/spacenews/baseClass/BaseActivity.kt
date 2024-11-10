package com.example.spacenews.baseClass

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.spacenews.R
import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent
import java.util.Locale

@Module
@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {


    private var dialog: Dialog?=null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        //userPref=UserPref(this)
    }


    protected fun hideProgressDialog() {
        if (dialog != null && dialog!!.isShowing)
            dialog!!.dismiss()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (dialog != null && dialog!!.isShowing)
            dialog!!.dismiss()
    }

    /*fun snackBar(message: String){
        Snackbar.make(findViewById(R.id.content), message, Snackbar.LENGTH_SHORT).show()
    }*/

    protected fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.flContent, fragment, fragment.javaClass.name).commit()
    }

    fun changeLanguage( prefLanguage:String)
    {
        val locale = Locale(prefLanguage)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        resources.updateConfiguration(config, resources.getDisplayMetrics())
    }
    fun snackbar(message: String){
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()
    }

    fun toast(context : Context, message: String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

//    open fun onPaymentSuccess(p0: String?, p1: PaymentData?) {}
}
