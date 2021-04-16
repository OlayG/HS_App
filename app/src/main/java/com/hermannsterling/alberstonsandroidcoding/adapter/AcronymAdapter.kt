package com.hermannsterling.alberstonsandroidcoding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hermannsterling.alberstonsandroidcoding.databinding.ItemLongFormBinding
import com.hermannsterling.alberstonsandroidcoding.model.LongForm

class AcronymAdapter(private val longForms: List<LongForm>) :
    RecyclerView.Adapter<AcronymAdapter.AcronymViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcronymViewHolder {
        val binding = ItemLongFormBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AcronymViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AcronymViewHolder, position: Int) {
        val longForm = longForms[position]
        holder.bind(longForm)
    }

    override fun getItemCount(): Int {
        return longForms.size
    }

    class AcronymViewHolder(private val binding: ItemLongFormBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(longForm: LongForm) {
            binding.longForm = longForm
        }
    }
}