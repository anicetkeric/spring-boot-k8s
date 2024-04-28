
package com.bootlabs.repository;

import com.bootlabs.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * <h2>BookRepository</h2>
 * Description: repository for the {@link Book} model.
 * 
 * @author @bootteam
 */
@Slf4j
@Repository
public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    public BookRepository(){
        IntStream.range(0, 10).forEach(i -> books.add(Book.builder()
                .id(String.valueOf(i))
                .isbn("IBN"+i)
                .title("TITLE"+i)
                .description("Desc"+i)
                .page(100+1)
                .price(BigDecimal.valueOf(1000L+1))
                .build()));
    }

    public Book save(Book book){
        return book;
    }

    public Book update(Book book){
        return book;
    }

    public Optional<Book> findById(String id){
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public List<Book> findAll(){
        return books;
    }

    public void deleteById(String id){
        log.debug("Delete book with id: {}", id);
    }

}
