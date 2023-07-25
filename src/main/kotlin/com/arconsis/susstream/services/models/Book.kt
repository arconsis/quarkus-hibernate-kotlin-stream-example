package com.arconsis.susstream.services.models

import java.util.UUID

data class Book (
    val id: UUID,
    val title: String,
    val authors: List<Author>
)