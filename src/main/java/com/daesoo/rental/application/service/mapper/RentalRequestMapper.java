package com.daesoo.rental.application.service.mapper;

import com.daesoo.rental.adaptor.in.request.RentalSaveRequestDto;
import com.daesoo.rental.adaptor.out.persistence.RentalJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentalRequestMapper extends EntityMapper<RentalSaveRequestDto, RentalJpaEntity> {}
