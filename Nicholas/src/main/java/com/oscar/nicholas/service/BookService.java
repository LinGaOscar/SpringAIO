package com.oscar.nicholas.service;

import com.oscar.nicholas.domain.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);

    Book updateBook(Book book);

    void deleteBook(Long id);

    void deleteAllBook();

    List<Book> findAll();

    Book getBookById(Long id);

}
