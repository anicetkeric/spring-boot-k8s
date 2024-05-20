package com.bootlabs.service.impl;


import com.bootlabs.service.AuthorService;
import com.bootlabs.model.Author;
import com.bootlabs.repository.AuthorRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;

/**
 * Service Implementation for managing {@link Author}.
 *
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
    public Author create(Author author) {
        return repository.save(author);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Author update(Author author) {
        Author existingAuthor = repository.findById(author.getId()).orElse(null);
        if (Objects.isNull(existingAuthor)) {
            throw new RuntimeException("Author Id is not found");
        }
        existingAuthor.setFirstname(author.getFirstname());
        existingAuthor.setLastname(author.getLastname());

        return repository.save(existingAuthor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Author getOne(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Author Id is not found"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Author> getAll() {
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
