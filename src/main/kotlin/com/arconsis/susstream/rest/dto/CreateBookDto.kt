package com.arconsis.susstream.rest.dto

import java.util.*

data class CreateBookDto(
    val title: String,
    val authors: List<UUID>
)