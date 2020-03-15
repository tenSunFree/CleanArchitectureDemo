package com.home.domain.repository

import com.home.domain.model.Main
import io.reactivex.Single

interface MainRepository : Repository {

    fun getData(): Single<List<Main>>
}