package com.home.data.common.base

import com.home.domain.model.Model

interface EntityMapper<M : Model, ME : ModelEntity> {

    fun mapToDomain(entity: ME): M

    fun mapToEntity(model: M): ME
}