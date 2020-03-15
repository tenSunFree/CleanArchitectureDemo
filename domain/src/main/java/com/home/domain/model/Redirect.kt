package com.home.domain.model

import com.home.domain.annotation.Redirect

data class Redirect(@Redirect val redirect: Int, val redirectObject: Any? = null)