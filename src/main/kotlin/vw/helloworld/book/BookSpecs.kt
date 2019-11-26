package vw.helloworld.book

import org.springframework.data.jpa.domain.Specification
import java.time.LocalDateTime

object BookSpecs {
    fun nameContains(word: String): Specification<Book> {
        return Specification { root, _, cb ->
            cb.like(root.get(Book_.name), "%$word%")
        }
    }

    fun publishedDateRange(startDate: LocalDateTime, endDate: LocalDateTime): Specification<Book> {
        return Specification { root, _, cb ->
            cb.and(cb.greaterThanOrEqualTo(root.get(Book_.publishedDate), startDate),
                    cb.lessThan(root.get(Book_.publishedDate), endDate))
        }
    }

    fun author(author: String): Specification<Book> {
        return Specification { root, _, cb ->
            cb.equal(root.get(Book_.author), author)
        }
    }
}