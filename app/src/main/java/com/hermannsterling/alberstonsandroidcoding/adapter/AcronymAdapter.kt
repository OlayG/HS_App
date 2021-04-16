package com.hermannsterling.alberstonsandroidcoding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hermannsterling.alberstonsandroidcoding.databinding.ItemLongFormBinding
import com.hermannsterling.alberstonsandroidcoding.model.LongForm

class AcronymAdapter(
    private val listener: (LongForm) -> Unit
) : RecyclerView.Adapter<AcronymAdapter.AcronymViewHolder>() {

    private val longForms = mutableListOf<LongForm>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemLongFormBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    ).let {
        AcronymViewHolder(it).apply {
            it.root.setOnClickListener { listener.invoke(longForms[adapterPosition]) }
        }
    }

    override fun onBindViewHolder(holder: AcronymViewHolder, position: Int) {
        holder.bind(longForms[position])
    }

    override fun getItemCount() = longForms.size

    fun setLongForms(data: List<LongForm>) {
        longForms.clear()
        longForms.addAll(data)
        notifyDataSetChanged()
    }

    class AcronymViewHolder(
        private val binding: ItemLongFormBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(longForm: LongForm) {
            binding.longForm = longForm
            binding.executePendingBindings()
        }
    }
}