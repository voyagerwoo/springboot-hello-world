package vw.helloworld.book

import java.time.LocalDateTime
import javax.persistence.*


@Entity
data class Book (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        val isbn: String,
        var name: String,
        var author: String,
        val publishedDate: LocalDateTime,
        val publisher: String
)