package com.daesoo.rental.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 대출 도서 테이
 */
@Entity
@Table(name = "rented_item")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentedItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "rented_date")
    private LocalDate rentedDate;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rental rental;

    public static RentedItem createRentedItem(Long bookId, String bookTitle, LocalDate rentedDate) {
        RentedItem rentedItem = new RentedItem();
        rentedItem.setBookId(bookId);
        rentedItem.setBookTitle(bookTitle);
        rentedItem.setRentedDate(rentedDate);
        rentedItem.setDueDate(rentedDate.plusWeeks(2));
        return rentedItem;
    }
    // jhipster-needle-entity-add-field - JHipster will add fields here

    /*   public Long getId() {
        return this.id;
    }

    public RentedItem id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return this.bookId;
    }

    public RentedItem bookId(Long bookId) {
        this.setBookId(bookId);
        return this;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public LocalDate getRentedDate() {
        return this.rentedDate;
    }

    public RentedItem rentedDate(LocalDate rentedDate) {
        this.setRentedDate(rentedDate);
        return this;
    }

    public void setRentedDate(LocalDate rentedDate) {
        this.rentedDate = rentedDate;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public RentedItem dueDate(LocalDate dueDate) {
        this.setDueDate(dueDate);
        return this;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Rental getRental() {
        return this.rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public RentedItem rental(Rental rental) {
        this.setRental(rental);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RentedItem)) {
            return false;
        }
        return getId() != null && getId().equals(((RentedItem) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RentedItem{" +
            "id=" + getId() +
            ", bookId=" + getBookId() +
            ", rentedDate='" + getRentedDate() + "'" +
            ", dueDate='" + getDueDate() + "'" +
            "}";
    }*/
}
