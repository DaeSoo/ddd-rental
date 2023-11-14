package com.daesoo.rental.service.mapper;

import com.daesoo.rental.domain.Rental;
import com.daesoo.rental.service.dto.RentalDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Rental} and its DTO {@link RentalDTO}.
 */
@Mapper(componentModel = "spring")
public interface RentalMapper extends EntityMapper<RentalDTO, Rental> {}
