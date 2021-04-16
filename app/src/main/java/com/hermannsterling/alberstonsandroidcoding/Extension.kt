package com.hermannsterling.alberstonsandroidcoding

import android.view.View
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputLayout
import com.hermannsterling.alberstonsandroidcoding.utils.State
import com.hermannsterling.alberstonsandroidcoding.utils.State.Companion.isError
import com.hermannsterling.alberstonsandroidcoding.utils.State.Companion.isLoading
import com.hermannsterling.alberstonsandroidcoding.utils.State.Companion.isSuccess

@BindingAdapter("app:setAdapter")
fun RecyclerView.setAdapter(adapter: RecyclerView.Adapter<*>) {
    this.adapter = adapter
}

@BindingAdapter(value = ["app:setupVisibility"])
fun View.setupVisibility(state: State?) {
    if (state == null) return
    when (this) {
        is TextInputLayout -> {
            isErrorEnabled = state.isError
            if (state is State.Error) error = state.msg
        }
        is ProgressBar -> isVisible = state.isLoading
        is RecyclerView -> isVisible = state.isSuccess

    }
}