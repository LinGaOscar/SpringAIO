package com.oscar.issac.controller;

import com.oscar.issac.domain.Book;
import com.oscar.issac.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/book")
public class BookController {
    private final Logger logger = LoggerFactory.getLogger(BookController.class);
    private BookService bookService;

    @Autowired
    public void autoWired(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public String getBookPage(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book";
    }

    @ExceptionHandler({Exception.class})
    public ModelAndView handleException(HttpServletRequest request, Exception e) throws Exception {
        logger.error("Request URL:{} , Exception : {}", request.getRequestURL(), e.getMessage());

        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.addObject("exception", e);
        modelAndView.setViewName("error/error");
        return modelAndView;
    }
}
