package com.hermannsterling.alberstonsandroidcoding.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<in T>(
    @LayoutRes private val layoutResId: Int
) : AppCompatActivity() where T : ViewDataBinding {

    abstract fun onActivityCreated(binding: T)

    final override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        this@BaseActivity.initial()
    }

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this@BaseActivity.initial()
    }

    private fun initial() =
        onActivityCreated(DataBindingUtil.setContentView(this@BaseActivity, layoutResId))
}
