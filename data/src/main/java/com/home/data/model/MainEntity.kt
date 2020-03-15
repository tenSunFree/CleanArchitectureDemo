package com.home.data.model

import com.home.data.common.base.EntityMapper
import com.home.data.common.base.ModelEntity
import com.home.domain.model.Main
import javax.inject.Inject

data class MainEntity(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
) : ModelEntity()

class MainEntityMapper @Inject constructor() : EntityMapper<Main, MainEntity> {

    override fun mapToDomain(entity: MainEntity) = Main(
        postId = entity.postId,
        id = entity.id,
        name = entity.name,
        email = entity.email,
        body = entity.body
    )

    override fun mapToEntity(model: Main) = MainEntity(
        postId = model.postId,
        id = model.id,
        name = model.name,
        email = model.email,
        body = model.body
    )
}

