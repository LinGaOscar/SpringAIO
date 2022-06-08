package com.oscar.issac.service;

import com.oscar.issac.domain.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);

    Book updateBook(Book book);

    List<Book> findAll(Book book);

    Book getBookById(Long id);
}
