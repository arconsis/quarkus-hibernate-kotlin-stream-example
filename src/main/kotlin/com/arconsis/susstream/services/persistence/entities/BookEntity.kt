package com.arconsis.susstream.services.persistence.entities

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "books")
@NamedQueries(
    NamedQuery(name = BookEntity.FIND_ALL_BOOKS, query = "SELECT b FROM BookEntity b ORDER BY b.title ASC")
)
class BookEntity(
    @Id
    @GeneratedValue
    var id: UUID? = null,

    var title: String,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "book_authors")
    @OrderBy(value = "name ASC")
    var authors: MutableSet<AuthorEntity> = mutableSetOf()
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BookEntity

        return id == other.id
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "BookEntity(id=$id, title='$title')"
    }

    companion object{
        const val FIND_ALL_BOOKS = "FIND_ALL_BOOKS"
    }
}