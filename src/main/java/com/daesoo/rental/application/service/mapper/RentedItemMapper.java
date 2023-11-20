package com.daesoo.rental.application.service.mapper;

import com.daesoo.rental.application.service.dto.RentedItemDTO;
import com.daesoo.rental.domain.RentedItem;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link RentedItem} and its DTO {@link RentedItemDTO}.
 */
@Mapper(componentModel = "spring")
public interface RentedItemMapper extends EntityMapper<RentedItemDTO, RentedItem> {
    /*    @Mapping(target = "rental", source = "rental", qualifiedByName = "rentalId")
    RentedItemDTO toDto(RentedItem s);

    @Named("rentalId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    RentalDTO toDtoRentalId(Rental rental);*/
}
