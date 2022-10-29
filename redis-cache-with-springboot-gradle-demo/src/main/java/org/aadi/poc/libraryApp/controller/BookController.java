package org.aadi.poc.libraryApp.controller;

import java.util.List;

import org.aadi.poc.libraryApp.model.Book;
import org.aadi.poc.libraryApp.service.BookService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
 
    private final BookService bookService;

    @PostMapping("/create")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }
    
    @GetMapping("/search/all")
    public List<Book> getAllBook() {
        return (List<Book>) bookService.getAllBook();
    }

    @GetMapping("/search/{id}")
    public Book getBook(@PathVariable long id) {
        return bookService.getBook(id);
    }

    @DeleteMapping("/del/{id}")
    public String deleteBook(@PathVariable long id) {
        return bookService.deleteBook(id);
    }
}