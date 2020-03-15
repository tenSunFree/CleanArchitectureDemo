package com.home.domain.exception

import com.home.domain.model.Dialog
import com.home.domain.annotation.ExceptionType

class DialogException(
    override val code: Int,
    val dialog: Dialog
) : CleanException(code, ExceptionType.DIALOG, null)