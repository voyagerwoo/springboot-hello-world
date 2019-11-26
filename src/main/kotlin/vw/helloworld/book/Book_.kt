package vw.helloworld.book

import java.time.LocalDateTime
import javax.persistence.metamodel.SingularAttribute
import javax.persistence.metamodel.StaticMetamodel

@StaticMetamodel(Book::class)
object Book_ {
    @JvmField var id: SingularAttribute<Book, Long>? = null
    @JvmField var isbn: SingularAttribute<Book, String>? = null
    @JvmField var name: SingularAttribute<Book, String>? = null
    @JvmField var author: SingularAttribute<Book, String>? = null
    @JvmField var publishedDate: SingularAttribute<Book, LocalDateTime>? = null
    @JvmField var publisher: SingularAttribute<Book, String>? = null
}
