package com.hermannsterling.alberstonsandroidcoding.view

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hermannsterling.alberstonsandroidcoding.adapter.AcronymAdapter
import com.hermannsterling.alberstonsandroidcoding.databinding.ActivityMainBinding
import com.hermannsterling.alberstonsandroidcoding.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.setContentView(binding.root).run {
            binding.lifecycleOwner = this@MainActivity
            binding.viewModel = viewModel
        }

        setListener()
        initObserver()
    }


    private fun initObserver() {
        viewModel.acronym.observe(this) {
            binding.adapter = AcronymAdapter(it.longForms)
        }
    }

    private fun setListener() {
        binding.btnSearch.setOnClickListener {
            fetchLongForm()
        }
    }

    private fun fetchLongForm() {
        viewModel.fetchAcronym(binding.etSearch.text.toString())
    }
}