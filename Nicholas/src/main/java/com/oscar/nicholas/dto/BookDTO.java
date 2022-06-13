package com.oscar.nicholas.dto;

import com.oscar.nicholas.domain.Book;
import com.oscar.nicholas.util.CustomBeanUtils;
import lombok.Data;
import org.springframework.beans.BeanUtils;


@Data
public class BookDTO {
    private String author;
    private String description;
    private String name;
    private Integer status;

    public void convertToBook(Book book) {
        new BookConvert().convert(this, book);
    }

    private class BookConvert implements Convert<BookDTO, Book> {
        @Override
        public Book convert(BookDTO bookDTO, Book book) {
            String[] nullPropertyNames = CustomBeanUtils.getNullPropertyNames(bookDTO);
            BeanUtils.copyProperties(bookDTO, book, nullPropertyNames);
            return book;
        }
    }
}
