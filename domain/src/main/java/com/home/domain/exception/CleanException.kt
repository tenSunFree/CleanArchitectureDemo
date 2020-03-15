package com.home.domain.exception

import com.home.domain.annotation.ExceptionType

open class CleanException(
    open val code: Int,
    @ExceptionType val exceptionType: Int,
    override val message: String?
) : Throwable(message)