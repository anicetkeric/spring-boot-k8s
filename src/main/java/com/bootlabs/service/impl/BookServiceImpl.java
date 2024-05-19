package com.bootlabs.service.impl;


import com.bootlabs.service.BookService;
import com.bootlabs.model.Book;
import com.bootlabs.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Service Implementation for managing {@link Book}.
 *
 * @author @bootteam
 */
@Service
public class BookServiceImpl implements BookService {


    private final BookRepository repository;

    public BookServiceImpl(BookRepository repo) {
        this.repository = repo;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Book create(Book book) {
        return repository.save(book);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book update(Book book) {
        Book existingBook = repository.findById(book.getId()).orElse(null);
        if (Objects.isNull(existingBook)) {
            throw new RuntimeException("Book Id is not found");
        }
        existingBook.setDescription(book.getDescription());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setPage(book.getPage());
        existingBook.setTitle(book.getTitle());
        existingBook.setPrice(book.getPrice());

        return repository.save(existingBook);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book getOne(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Book Id is not found"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

}
