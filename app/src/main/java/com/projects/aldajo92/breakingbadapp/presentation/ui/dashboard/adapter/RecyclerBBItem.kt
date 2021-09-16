package com.projects.aldajo92.breakingbadapp.presentation.ui.dashboard.adapter

import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.databinding.ItemDashboardBinding
import com.projects.aldajo92.breakingbadapp.presentation.adapter.GenericItem
import com.projects.aldajo92.breakingbadapp.presentation.adapter.ItemListener

data class RecyclerBBItem(
    val character: BBCharacter,
    val layout: Int,
    val modelId: Int
) : GenericItem<BBCharacter>(character, layout, modelId) {

    var binding: ItemDashboardBinding? = null

    override fun bind(binding: ViewDataBinding, listener: ItemListener<BBCharacter>) {
        this.binding = binding as ItemDashboardBinding
        this.binding?.apply {
            setVariable(variableId, data)

            viewCover.setOnClickListener {
                listener.onClickItem(this@RecyclerBBItem)
            }

            if (character.imageUrl.isNotBlank()) {
                Glide.with(binding.root.context)
                    .load(character.imageUrl)
                    .into(binding.imageViewPicture)
            }
        }
    }

}
