package com.daesoo.rental.application.service.mapper;

import com.daesoo.rental.adaptor.out.persistence.RentalJpaEntity;
import com.daesoo.rental.application.service.dto.RentalDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentalDtoMapper extends EntityMapper<RentalDTO, RentalJpaEntity> {}
