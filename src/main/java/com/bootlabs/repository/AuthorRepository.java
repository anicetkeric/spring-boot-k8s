
package com.bootlabs.repository;

import com.bootlabs.model.Author;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * <h2>AuthorRepository</h2>
 * Description: Spring Data repository for the {@link Author} entity.
 * 
 * @author @bootteam
 */
@Slf4j
@Repository
public class AuthorRepository {

    private final List<Author> authors = new ArrayList<>();

    public AuthorRepository(){
        IntStream.range(0, 10).forEach(i -> authors.add(Author.builder()
                .id(String.valueOf(i))
                .lastname("LASTNAME"+i)
                .firstname("FIRSTNAME"+i)
                .build()));
    }

    public Author save(Author author){
        return author;
    }

    public Author update(Author author){
        return author;
    }

    public Optional<Author> findById(String id){
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst();
    }

    public List<Author> findAll(){
        return authors;
    }

    public void deleteById(String id){
        log.debug("Delete book with id: {}", id);
    }



}
