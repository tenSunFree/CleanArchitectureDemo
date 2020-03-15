package com.home.domain.exception

import com.home.domain.model.Tag
import com.home.domain.annotation.ExceptionType

class InlineException(
    override val code: Int,
    vararg val tags: Tag
) : CleanException(code, ExceptionType.INLINE, null)