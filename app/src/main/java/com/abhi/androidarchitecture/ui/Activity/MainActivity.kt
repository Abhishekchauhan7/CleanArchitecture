package com.abhi.androidarchitecture.ui.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.abhi.androidarchitecture.BR
import com.abhi.androidarchitecture.R
import com.abhi.androidarchitecture.base.BaseActivity
import com.abhi.androidarchitecture.databinding.ActivityMainBinding
import com.abhi.androidarchitecture.navigator.loginNavigator
import com.abhi.androidarchitecture.ui.Activity.SecondActivity.SecondActivity
import com.abhi.androidarchitecture.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(), loginNavigator, View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.main_btn -> SwitchActivity()
        }

    }




    @Inject
    lateinit var viewModel: LoginViewModel
    private var activityMainBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = viewDataBinding!!
        viewModel.setNavigator(this)
        setup()
    }

    private fun setup() {
        main_btn.setOnClickListener(this)
    }


    private fun SwitchActivity() {
        startActivity(Intent(this,SecondActivity::class.java))
    }
    override val bindingVariable: Int
        get() = BR._all
    override val layoutId: Int
        get() = R.layout.activity_main

    override fun onSuccess(message: String) {
        Log.d("", message)
    }

    override fun onError(error: String) {
        Log.d("", error)
    }

}
