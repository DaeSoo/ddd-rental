package com.daesoo.rental.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CatalogChanged {

    private String title;

    private String description;

    private String author;

    private String publicationDate;

    private String classification;

    private Boolean rented;

    private Long rentCnt;

    private String eventType;

    private Long bookId;
}
