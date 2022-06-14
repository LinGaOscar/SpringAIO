package com.oscar.nicholas.dto;

import com.oscar.nicholas.domain.Book;
import com.oscar.nicholas.util.CustomBeanUtils;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class BookDTO implements Serializable {
    @NotBlank
    private String author;
    private String description;
    @NotBlank
    private String name;
    @NotNull
    private Integer status;

    public void convertToBook(Book book) {
        new BookConvert().convert(this, book);
    }

    public Book convertToBook() {
        return new BookConvert().convert(this);
    }

    private class BookConvert implements Convert<BookDTO, Book> {
        @Override
        public Book convert(BookDTO bookDTO, Book book) {
            String[] nullPropertyNames = CustomBeanUtils.getNullPropertyNames(bookDTO);
            BeanUtils.copyProperties(bookDTO, book, nullPropertyNames);
            return book;
        }

        @Override
        public Book convert(BookDTO bookDTO) {
            Book book = new Book();
            BeanUtils.copyProperties(bookDTO, book);
            return book;
        }
    }
}
