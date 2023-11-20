package com.daesoo.rental.application.service.dto;

import com.daesoo.rental.domain.enumeration.RentalStatus;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * A DTO for the {@link com.daesoo.rental.domain.Rental} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
@Getter
@Setter
public class RentalDTO implements Serializable {

    private Long id;

    private Long userId;

    private RentalStatus rentalStatus;
}
