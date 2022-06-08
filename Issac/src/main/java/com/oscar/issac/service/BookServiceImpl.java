package com.oscar.issac.service;

import com.oscar.issac.domain.Book;
import com.oscar.issac.domain.BookRepository;
import com.oscar.issac.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public void autowired(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll(Book book) {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            throw new BookNotFoundException("查無書本");
        }
        return book;
    }
}
