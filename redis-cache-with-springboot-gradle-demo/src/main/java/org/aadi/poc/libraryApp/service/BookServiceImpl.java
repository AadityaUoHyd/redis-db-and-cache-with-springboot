package org.aadi.poc.libraryApp.service;


import java.util.List;
import java.util.Optional;

import org.aadi.poc.libraryApp.model.Book;
import org.aadi.poc.libraryApp.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
	
	private final BookRepository bookRepository;

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    
    @Override
    public Book addBook(Book book) {
        logger.info("adding book with id - {}", book.getId());
        return bookRepository.save(book);
    }
    
    @Override
	public List<Book> getAllBook() {
    	logger.info("trying to fetch all books from db or cache");
        return bookRepository.findAll();
	}

    @Override
    @CachePut(cacheNames = "books", key = "#book.id")
    public Book updateBook(Book book) {
    	Book bookDb = bookRepository.findById(book.getId()).get();
		if(book.getId()==bookDb.getId()){
			logger.info("book updated with new changes");
			bookDb.setName(book.getName());
			bookDb.setCategory(book.getCategory());
			bookDb.setAuthor(book.getAuthor());
			bookDb.setPublisher(book.getPublisher());
			bookDb.setEdition(book.getEdition());
		}
		return bookRepository.save(bookDb);
    }

    @Override
    @Cacheable(cacheNames = "books", key = "#id")
    public Book getBook(long id) {
        logger.info("trying to fetch book from db or cache");
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        } else {
            return new Book();
        }
    }

    @Override
    @CacheEvict(cacheNames = "books", key = "#id")
    public String deleteBook(long id) {    	
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
        	logger.info("trying to delete book from db and cache");
        	 bookRepository.deleteById(id);
             return "Book deleted";
        } else {
            return "This Book can't be deleted, as book with this ID didn't exist in database!";
        }
       
    }

}