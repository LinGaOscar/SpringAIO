package com.oscar.nicholas.api;

import com.oscar.nicholas.domain.Book;
import com.oscar.nicholas.dto.BookDTO;
import com.oscar.nicholas.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookApi {

    private BookService bookService;

    @Autowired
    public void autoWired(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<?> listAllBook() {
        List<Book> books = bookService.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBook(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<?> saveBook(@RequestBody Book book) {
        Book saveBook = bookService.saveBook(book);
        return new ResponseEntity<>(saveBook, HttpStatus.CREATED);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        Book currentBook = bookService.getBookById(id);
        bookDTO.convertToBook(currentBook);
        Book book1 = bookService.saveBook(currentBook);
        return new ResponseEntity<>(book1, HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/books")
    public ResponseEntity<?> deleteAllBook() {
        bookService.deleteAllBook();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
