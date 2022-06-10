package com.oscar.nicholas.api;

import com.oscar.nicholas.domain.Book;
import com.oscar.nicholas.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookApi {

    private BookService bookService;

    @Autowired
    public void autoWired(BookService bookService) {
        this.bookService = bookService;
    }


    public List<Book> listAllBook() {
        return bookService.findAll();
    }
}
