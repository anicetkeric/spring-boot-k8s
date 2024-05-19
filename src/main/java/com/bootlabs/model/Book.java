package com.bootlabs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * model class for "Book"
 *
 * @author @bootteam
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Book {

    @Id
    private String id;

    private String title;

    private String isbn;

    private String description;

    private Integer page;

    private BigDecimal price;

}
