package com.bootlabs.service.impl;


import com.bootlabs.service.AuthorService;
import com.bootlabs.model.Author;
import com.bootlabs.repository.AuthorRepository;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link Author}.
 * @author @bootteam
 */
@Service
public class AuthorServiceImpl implements AuthorService {


    private final AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repo) {
         this.repository = repo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Author create(Author d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Author update(Author d) {
        try {
            return repository.update(d);

        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Author getOne(String id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Author> getAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

}
