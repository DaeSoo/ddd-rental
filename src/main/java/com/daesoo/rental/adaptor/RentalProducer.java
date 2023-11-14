package com.daesoo.rental.adaptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.concurrent.ExecutionException;

/*
 대출 서비스에 카프카 Producer 만들기
 */
public interface RentalProducer {
    void updateBookStatus(Long bookId, String bookStatus) throws ExecutionException, InterruptedException, JsonProcessingException;

    void savePoints(Long userId, int pointPerBooks) throws JsonProcessingException, ExecutionException, InterruptedException;

    void updateBookCatalogStatus(Long bookId, String eventType) throws JsonProcessingException, ExecutionException, InterruptedException;
}
