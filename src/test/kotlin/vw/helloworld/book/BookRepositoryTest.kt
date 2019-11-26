package vw.helloworld.book

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.jpa.domain.Specification.where
import vw.helloworld.book.Book
import vw.helloworld.book.BookRepository
import vw.helloworld.book.BookSpecs
import java.time.LocalDateTime

@AutoConfigureTestDatabase
@DataJpaTest
internal class BookRepositoryTest {
    @Autowired
    private lateinit var bookRepository: BookRepository

    @Test
    internal fun saveAndFindAll() {
        bookRepository.save(Book(isbn = "test-isbn1", name = "쿠버네티스 시작하기", author = "켈시 하이타워 외", publishedDate = LocalDateTime.now(), publisher = "에이콘"))
        bookRepository.save(Book(isbn = "test-isbn2", name = "스플랜더", author = "하하하", publishedDate = LocalDateTime.now(), publisher = "보드게임사"))

        val books = bookRepository.findAll()
        println(books)

        assertThat(books).hasSize(2);
    }

    @Test
    internal fun findAllBySpecs() {
        bookRepository.save(Book(isbn = "test-isbn1", name = "쿠버네티스 시작하기", author = "켈시 하이타워 외", publishedDate = LocalDateTime.now(), publisher = "에이콘"))
        bookRepository.save(Book(isbn = "test-isbn2", name = "스플랜더", author = "하하하", publishedDate = LocalDateTime.now(), publisher = "보드게임사"))

        val books = bookRepository.findAll(where(BookSpecs.author("하하하"))
                ?.and(BookSpecs.nameContains("스플"))!!)
        println(books)

        assertThat(books).hasSize(1)
    }
}