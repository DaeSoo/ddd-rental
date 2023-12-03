package com.daesoo.rental.adaptor.in.web;

import com.daesoo.rental.adaptor.in.request.RentalSaveRequestDto;
import com.daesoo.rental.application.port.in.usecase.GetRentalUseCase;
import com.daesoo.rental.application.port.in.usecase.PostRentalUseCase;
import com.daesoo.rental.application.service.dto.RentalDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 프레젠테이션 계층
 */
@RestController
@RequestMapping("/api/rentals")
@Slf4j
@RequiredArgsConstructor
public class RentalResourceController {

    private final GetRentalUseCase getRentalUseCase;
    private final PostRentalUseCase postRentalUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<RentalDTO> rental(@PathVariable Long id) {
        return ResponseEntity.ok().body(getRentalUseCase.rental(id).get());
    }

    @PostMapping
    public ResponseEntity<RentalDTO> rentalSave(@RequestBody RentalSaveRequestDto rentalSaveRequestDto) {
        return ResponseEntity.ok().body(postRentalUseCase.saveRental(rentalSaveRequestDto));
    }
}
