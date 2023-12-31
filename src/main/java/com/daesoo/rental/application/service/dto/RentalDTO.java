package com.daesoo.rental.application.service.dto;

import com.daesoo.rental.domain.enumeration.RentalStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A DTO for the {@link com.daesoo.rental.domain.Rental} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalDTO {

    private Long id;

    private Long userId;

    private RentalStatus rentalStatus;
}
