package com.projects.aldajo92.breakingbadapp.presentation.ui.dashboard.adapter

import androidx.databinding.ObservableField
import androidx.databinding.ViewDataBinding
import com.projects.aldajo92.breakingbadapp.BR
import com.projects.aldajo92.breakingbadapp.databinding.ItemDashboardBinding
import com.projects.aldajo92.breakingbadapp.domain.BBCharacter
import com.projects.aldajo92.breakingbadapp.presentation.adapter.GenericItem
import com.projects.aldajo92.breakingbadapp.presentation.adapter.ItemListener

class RecyclerBBItem(
    val character: BBCharacter,
    layout: Int
) : GenericItem<BBCharacter>(character, layout) {

    val favoriteStatusField = ObservableField<Boolean>()

    override fun bind(binding: ViewDataBinding, listener: ItemListener<BBCharacter>) {
        favoriteStatusField.set(character.isFavorite)
        (binding as ItemDashboardBinding)
            .apply {
                setVariable(BR.item, this@RecyclerBBItem)

                cardView.setOnClickListener {
                    listener.onClickItem(this@RecyclerBBItem)
                }

                imageViewFavorite.setOnClickListener {
                    listener.onFavoriteClicked(this@RecyclerBBItem)
                }
            }
    }
}
