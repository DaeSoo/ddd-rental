package com.daesoo.rental.application.service;

import com.daesoo.rental.application.port.in.usecase.GetRentalUseCase;
import com.daesoo.rental.application.port.out.LoadRentalPort;
import com.daesoo.rental.application.service.dto.RentalDTO;
import com.daesoo.rental.application.service.mapper.RentalMapper;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetRentalService implements GetRentalUseCase {

    private final LoadRentalPort loadRentalPort;
    private final RentalMapper rentalMapper;

    @Override
    public Optional<RentalDTO> rental(Long id) {
        return Optional.ofNullable(rentalMapper.toDto(loadRentalPort.loadRental(id).get()));
    }
}
