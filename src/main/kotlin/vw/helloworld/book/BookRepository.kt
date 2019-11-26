package vw.helloworld.book

import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.QueryHints
import org.springframework.data.repository.Repository
import javax.persistence.QueryHint

interface BookRepository : Repository<Book, Long> {
    @QueryHints(value = [QueryHint(name="org.hibernate.comment", value="BookRepository.findAll")])
    fun findAll(): List<Book>

//    @QueryHints(value = [QueryHint(name="org.hibernate.comment", value="BookRepository.saves")])
    fun save(book: Book): Book

    @QueryHints(value = [QueryHint(name="org.hibernate.comment", value="BookRepository.findAllBySpecs")])
    fun findAll(specs: Specification<Book>): List<Book>
}