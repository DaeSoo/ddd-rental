package com.daesoo.rental.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * A DTO for the {@link com.daesoo.rental.domain.RentedItem} entity.
 */
@Getter
@Setter
@SuppressWarnings("common-java:DuplicatedBlocks")
public class RentedItemDTO implements Serializable {

    private Long id;

    private Long bookId;

    private LocalDate rentedDate;

    private LocalDate dueDate;

    private RentalDTO rental;
    /*    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RentedItemDTO)) {
            return false;
        }

        RentedItemDTO rentedItemDTO = (RentedItemDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, rentedItemDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RentedItemDTO{" +
            "id=" + getId() +
            ", bookId=" + getBookId() +
            ", rentedDate='" + getRentedDate() + "'" +
            ", dueDate='" + getDueDate() + "'" +
            ", rental=" + getRental() +
            "}";
    }*/
}
