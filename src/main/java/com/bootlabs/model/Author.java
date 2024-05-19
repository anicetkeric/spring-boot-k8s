package com.bootlabs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * model class for "Author"
 *
 * @author @bootteam
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Author {

    @Id
    private String id;

    private String lastname;

    private String firstname;
}
