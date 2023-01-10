package com.example.practicaltask.basemodel

import android.content.Context
import android.os.Bundle
import android.text.style.TtsSpan
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<v : ViewDataBinding>(@LayoutRes private val layoutResId: Int) :
    AppCompatActivity() {


     lateinit var binding: v
    private lateinit var context: Context
    abstract fun activityCreated()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= DataBindingUtil.setContentView(this,layoutResId)
        context=this
        activityCreated()

    }
}