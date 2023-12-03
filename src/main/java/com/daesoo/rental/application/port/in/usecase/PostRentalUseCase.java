package com.daesoo.rental.application.port.in.usecase;

import com.daesoo.rental.adaptor.in.request.RentalSaveRequestDto;
import com.daesoo.rental.application.service.dto.RentalDTO;

public interface PostRentalUseCase {
    RentalDTO saveRental(RentalSaveRequestDto rentalSaveRequestDto);
}
