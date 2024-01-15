package org.LihetCatalin.Spring_Assignment2.service;

import org.LihetCatalin.Spring_Assignment2.data.BookRepository;
import org.LihetCatalin.Spring_Assignment2.models.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return bookRepository.existsById(id);
    }

    @Override
    public boolean save(Book book) {
        bookRepository.save(book);
        return true;
    }

    @Override
    public boolean updateBook(Integer idBook, Book updatedBook) {
        return false;
    }

    @Override
    public void removeById(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void removeAll() {
        bookRepository.deleteAll();
    }
}
