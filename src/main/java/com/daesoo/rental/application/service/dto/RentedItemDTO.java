package com.daesoo.rental.application.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * A DTO for the {@link com.daesoo.rental.domain.RentedItem} entity.
 */
@Getter
@Setter
@SuppressWarnings("common-java:DuplicatedBlocks")
public class RentedItemDTO implements Serializable {

    private Long id;

    private Long bookId;

    private LocalDate rentedDate;

    private LocalDate dueDate;

    private RentalDTO rental;
}
