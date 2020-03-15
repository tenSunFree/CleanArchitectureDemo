package com.home.domain.model

import com.home.domain.annotation.TagName

data class Tag(@TagName val name: String, val message: String?)