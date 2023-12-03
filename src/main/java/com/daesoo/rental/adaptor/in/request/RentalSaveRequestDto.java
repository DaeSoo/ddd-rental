package com.daesoo.rental.adaptor.in.request;

import com.daesoo.rental.domain.enumeration.RentalStatus;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentalSaveRequestDto {

    private Long id;
    private Long userId;
    private RentalStatus rentalStatus;
    private Long bookId;
    private String bookTitle;
    private LocalDate rentedDate;
}
