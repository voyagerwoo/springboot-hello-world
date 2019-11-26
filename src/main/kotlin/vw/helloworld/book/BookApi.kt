package vw.helloworld.book

import org.springframework.data.jpa.domain.Specification
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class BookApi(private val bookRepository: BookRepository) {

    @GetMapping("/all-books")
    fun findAll(): List<Book> {
        return bookRepository.findAll()
    }

    @GetMapping("/books")
    fun findAllBySpecs(@RequestParam nameContains: String,
                       @RequestParam(required = false) author: String?): List<Book> {
        var specs = Specification
                .where(BookSpecs.nameContains(nameContains))!!
        if (author != null && author.isNotBlank())
            specs = specs.and(BookSpecs.author(author))!!

        return bookRepository.findAll(specs)
    }
}