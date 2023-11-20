package com.daesoo.rental.application.service.mapper;

import com.daesoo.rental.application.service.dto.RentalDTO;
import com.daesoo.rental.domain.Rental;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Rental} and its DTO {@link RentalDTO}.
 */
@Mapper(componentModel = "spring")
public interface RentalMapper extends EntityMapper<RentalDTO, Rental> {}
