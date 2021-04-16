package com.hermannsterling.alberstonsandroidcoding.view

import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.activity.viewModels
import com.hermannsterling.alberstonsandroidcoding.R
import com.hermannsterling.alberstonsandroidcoding.adapter.AcronymAdapter
import com.hermannsterling.alberstonsandroidcoding.base.BaseActivity
import com.hermannsterling.alberstonsandroidcoding.databinding.ActivityMainBinding
import com.hermannsterling.alberstonsandroidcoding.model.LongForm
import com.hermannsterling.alberstonsandroidcoding.utils.State
import com.hermannsterling.alberstonsandroidcoding.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel by viewModels<MainViewModel>()

    override fun onActivityCreated(binding: ActivityMainBinding) {
        initBinding(binding)
        setupObserver(binding)
    }

    private fun setupObserver(binding: ActivityMainBinding) {
        viewModel.state.observe(this) {
            if (it is State.Success)
                (binding.adapter as AcronymAdapter).setLongForms(it.data)
        }
    }

    private fun initBinding(binding: ActivityMainBinding) = with(binding) {
        lifecycleOwner = this@MainActivity
        viewModel = this@MainActivity.viewModel
        adapter = AcronymAdapter(::longFormSelected)
        etSearch.setOnEditorActionListener { v, actionId, event ->
            val imeAction = when (actionId) {
                EditorInfo.IME_ACTION_DONE,
                EditorInfo.IME_ACTION_SEND,
                EditorInfo.IME_ACTION_GO -> true
                else -> false
            }

            val keyDownEvent = event?.keyCode == KeyEvent.KEYCODE_ENTER
                    && event.action == KeyEvent.ACTION_DOWN

            return@setOnEditorActionListener if (imeAction || keyDownEvent) {
                this@MainActivity.viewModel.fetchAcronym(v);true
            } else false
        }
    }

    private fun longFormSelected(longForm: LongForm) {
        Toast.makeText(this, longForm.lf, Toast.LENGTH_SHORT).show()
    }
}
