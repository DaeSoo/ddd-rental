package com.daesoo.rental.application.port.in.usecase;

import com.daesoo.rental.application.service.dto.RentalDTO;
import java.util.Optional;

/**
 * port.in.usecase는 추상화를 위해 사용 실제 주입 되는 곳은 application.service
 *
 */
public interface GetRentalUseCase {
    /**
     *
     * @param id
     * @return
     */
    Optional<RentalDTO> rental(Long id);
}
