package com.altaf.furnitureshop.feature.home.domain.model

data class Banner(
    val id: Int,
    val title: String,
    val description: String? = null,
    val image: String,
    val status: String
)
