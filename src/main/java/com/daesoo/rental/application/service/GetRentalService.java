package com.daesoo.rental.application.service;

import com.daesoo.rental.application.port.in.usecase.GetRentalUseCase;
import com.daesoo.rental.application.port.out.persistence.LoadRentalPort;
import com.daesoo.rental.application.service.dto.RentalDTO;
import com.daesoo.rental.application.service.mapper.RentalDtoMapper;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetRentalService implements GetRentalUseCase {

    private final LoadRentalPort loadRentalPort;
    private final RentalDtoMapper rentalDtoMapper;

    @Override
    public Optional<RentalDTO> rental(Long id) {
        return Optional.ofNullable(rentalDtoMapper.toDto(loadRentalPort.getRental(id).get()));
    }
}
