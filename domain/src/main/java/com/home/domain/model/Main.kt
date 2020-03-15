package com.home.domain.model

data class Main(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
) : Model()
