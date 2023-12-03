package com.daesoo.rental.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RentalTest {

    @Test
    public void createRental_대출_카드를_생성한다() {
        Long userId = 1L;
        Rental rental = Rental.createRental(userId);
        assertThat(rental.getUserId()).isEqualTo(1L);
        assertThat(rental.getRentalStatus().toString()).isEqualTo("RENT_AVAILABLE");
        assertThat(rental.getLateFee()).isEqualTo(0);
    }
}
