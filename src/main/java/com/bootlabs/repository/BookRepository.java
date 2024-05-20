
package com.bootlabs.repository;

import com.bootlabs.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * <h2>BookRepository</h2>
 * Description: repository for the {@link Book} model.
 * 
 * @author @bootteam
 */
@Repository
public interface BookRepository extends MongoRepository<Book, String> {
}
