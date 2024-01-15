package org.LihetCatalin.Spring_Assignment2.service;

import org.LihetCatalin.Spring_Assignment2.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();
    Optional<Book> findById(Integer id);
    boolean existsById(Integer id);
    boolean save(Book book);
    boolean updateBook(Integer idBook, Book updatedBook);
    void removeById(Integer id);
    void removeAll();
}
