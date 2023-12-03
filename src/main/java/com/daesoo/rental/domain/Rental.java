package com.daesoo.rental.domain;

import com.daesoo.rental.domain.enumeration.RentalStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 대여 도메인
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Rental {

    private Long id;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private RentalStatus rentalStatus;

    private int lateFee;

    private Set<RentedItem> rentedItems;

    private Set<OverdueItem> overdueItems;

    private Set<ReturnedItem> returnedItems;

    public Rental(Long userId, RentalStatus rentalStatus, int lateFee) {
        this.userId = userId;
        this.rentalStatus = rentalStatus;
        this.lateFee = lateFee;
    }

    /**
     * 대출카드 생성
     *
     * @param userId
     * @return
     */
    public static Rental createRental(Long userId) {
        return new Rental(userId, RentalStatus.RENT_AVAILABLE, 0);
    }

    public Rental addRentedItem(RentedItem rentedItem) {
        this.rentedItems.add(rentedItem);
        rentedItem.setRental(this);
        return this;
    }

    public Rental removeRentedItem(RentedItem rentedItem) {
        this.rentedItems.remove(rentedItem);
        //rentedItem.setRental(null);
        return this;
    }

    public Rental addOverdueItem(OverdueItem overdueItem) {
        this.overdueItems.add(overdueItem);
        overdueItem.setRental(this);
        return this;
    }

    public Rental removeOverdueItem(OverdueItem overdueItem) {
        this.overdueItems.remove(overdueItem);
        // overdueItem.setRental(null);
        return this;
    }

    public Rental addReturnedItem(ReturnedItem returnedItem) {
        this.returnedItems.add(returnedItem);
        returnedItem.setRental(this);
        return this;
    }

    public Rental removeReturnedItem(ReturnedItem returnedItem) {
        this.returnedItems.remove(returnedItem);
        //  returnedItem.setRental(null);
        return this;
    }
    //
    //    /**
    //     * 대출 불가 처리
    //     *
    //     * @return
    //     */
    //    public Rental makeRentUnable() {
    //        this.setRentalStatus(RentalStatus.RENT_UNAVAILABLE);
    //        this.setLateFee(this.getLateFee() + 30); //연체시 연체비 30포인트 누적
    //        return this;
    //    }
    //
    //    /**
    //     * 대출하기
    //     *
    //     * @param bookid
    //     * @param title
    //     * @return
    //     */
    //    public Rental rentBook(Long bookid, String title) {
    //        this.addRentedItem(RentedItem.createRentedItem(bookid, title, LocalDate.now()));
    //        return this;
    //    }
    //
    //    /**
    //     * 반납하기
    //     *
    //     * @param bookId
    //     * @return
    //     */
    //    public Rental returnBook(Long bookId) {
    //        RentedItem rentedItem = this.rentedItems.stream().filter(item -> item.getBookId().equals(bookId)).findFirst().get();
    //        this.addReturnedItem(ReturnedItem.createReturnedItem(rentedItem.getBookId(), rentedItem.getBookTitle(), LocalDate.now()));
    //        this.removeRentedItem(rentedItem);
    //        return this;
    //    }
    //
    //    /**
    //     * 연체처리
    //     *
    //     * @param bookId
    //     * @return
    //     */
    //    public Rental overdueBook(Long bookId) {
    //        RentedItem rentedItem = this.rentedItems.stream().filter(item -> item.getBookId().equals(bookId)).findFirst().get();
    //        this.addOverdueItem(OverdueItem.createOverdueItem(rentedItem.getBookId(), rentedItem.getBookTitle(), rentedItem.getDueDate()));
    //        this.removeRentedItem(rentedItem);
    //        return this;
    //    }
    //
    //    /**
    //     * 연체된 책 반납
    //     *
    //     * @param bookId
    //     * @return
    //     */
    //    public Rental returnOverdueBook(Long bookId) {
    //        OverdueItem overdueItem = this.overdueItems
    //            .stream().filter(item -> item.getBookId().equals(bookId)).findFirst().get();
    //        this.addReturnedItem(ReturnedItem.createReturnedItem(overdueItem.getBookId(), overdueItem.getBookTitle(), LocalDate.now()));
    //        this.removeOverdueItem(overdueItem);
    //        return this;
    //    }
    //
    //    /**
    //     * 대출불가 해제
    //     *
    //     * @return
    //     */
    //    public Rental releaseOverdue() {
    //        this.setLateFee(0);
    //        this.setRentalStatus(RentalStatus.RENT_AVAILABLE);
    //        return this;
    //    }
    //
    //    //대출 가능 여부 체크 //
    //    public void checkRentalAvailable() throws RentUnavailableException {
    //        if (this.rentalStatus.equals(RentalStatus.RENT_UNAVAILABLE) || this.getLateFee() != 0)
    //            throw new RentUnavailableException("연체 상태입니다. 연체료를 정산 후, 도서를 대출하실 수 있습니다.");
    //        if (this.getRentedItems().size() >= 5)
    //            throw new RentUnavailableException("대출 가능한 도서의 수는 " + (5 - this.getRentedItems().size()) + "권 입니다.");
    //
    //    }
    //
    //
    //    public Rental lateFee(int lateFee) {
    //        this.lateFee = lateFee;
    //        return this;
    //    }
}
