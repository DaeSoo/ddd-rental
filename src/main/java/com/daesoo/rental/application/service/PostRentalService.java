package com.daesoo.rental.application.service;

import com.daesoo.rental.adaptor.in.request.RentalSaveRequestDto;
import com.daesoo.rental.adaptor.out.persistence.JpaRentalRepository;
import com.daesoo.rental.application.port.in.usecase.PostRentalUseCase;
import com.daesoo.rental.application.service.dto.RentalDTO;
import com.daesoo.rental.application.service.mapper.RentalDtoMapper;
import com.daesoo.rental.application.service.mapper.RentalRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostRentalService implements PostRentalUseCase {

    private final JpaRentalRepository rentalRepository;
    private final RentalRequestMapper rentalRequestMapper;
    private final RentalDtoMapper rentalDtoMapper;

    @Override
    public RentalDTO saveRental(RentalSaveRequestDto saveRequestDto) {
        return rentalDtoMapper.toDto(rentalRepository.save(rentalRequestMapper.toEntity(saveRequestDto)));
    }
}
