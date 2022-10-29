package org.aadi.poc.libraryApp.repository;

import javax.transaction.Transactional;

import org.aadi.poc.libraryApp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {
	
    @Transactional
    @Modifying
    @Query("update Book b set b.name=?2 where b.id=?1")
    int updateAddress(long id, String name);
    
}