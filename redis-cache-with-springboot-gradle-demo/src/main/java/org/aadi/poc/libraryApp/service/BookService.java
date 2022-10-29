package org.aadi.poc.libraryApp.service;

import java.util.List;

import org.aadi.poc.libraryApp.model.Book;

public interface BookService  {
    Book addBook(Book book);

    Book updateBook(Book book);

    Book getBook(long id);

    String deleteBook(long id);

	List<Book> getAllBook();
}