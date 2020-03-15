package com.home.domain.exception

import com.home.domain.annotation.ExceptionType
import com.home.domain.exception.CleanException

class ToastException(
    override val code: Int,
    override val message: String
) : CleanException(code, ExceptionType.TOAST, message)