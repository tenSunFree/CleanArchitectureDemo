package com.home.cleanarchitecturedemo.model

import android.os.Parcelable
import com.home.cleanarchitecturedemo.common.base.ItemMapper
import com.home.cleanarchitecturedemo.common.base.ModelItem
import com.home.domain.model.Main
import kotlinx.android.parcel.Parcelize
import javax.inject.Inject

@Parcelize
data class MainItem(
    val postId: Int,
    val id: String,
    val name: String,
    val email: String,
    val body: String
) : ModelItem(), Parcelable

class MainItemMapper @Inject constructor() : ItemMapper<Main, MainItem> {

    override fun mapToPresentation(model: Main) = MainItem(
        postId = model.postId,
        id = model.id.toString(),
        name = model.name,
        email = model.email,
        body = model.body
    )

    override fun mapToDomain(item: MainItem) = Main(
        postId = item.postId,
        id = item.id.toInt(),
        name = item.name,
        email = item.email,
        body = item.body
    )
}