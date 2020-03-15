package com.home.domain.exception

import com.home.domain.annotation.ExceptionType
import com.home.domain.exception.CleanException

class SnackBarException(
    override val code: Int,
    override val message: String
) : CleanException(code, ExceptionType.SNACK, message)