package com.home.domain.exception

import com.home.domain.model.Redirect
import com.home.domain.annotation.ExceptionType

class RedirectException(
    override val code: Int,
    val redirect: Redirect
) : CleanException(code, ExceptionType.REDIRECT, null)