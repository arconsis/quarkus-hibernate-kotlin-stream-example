package com.arconsis.susstream.services.models

import java.time.LocalDate
import java.util.UUID

data class Author(
    val id: UUID,
    val name: String,
    val birthdate: LocalDate?,
)
