package com.home.cleanarchitecturedemo.common.base

import com.home.domain.model.Model

interface ItemMapper<M : Model, MI : ModelItem> {

    fun mapToPresentation(model: M): ModelItem

    fun mapToDomain(item: MI): Model
}