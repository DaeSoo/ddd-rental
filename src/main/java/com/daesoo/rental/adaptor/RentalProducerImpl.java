package com.daesoo.rental.adaptor;

import com.daesoo.rental.config.KafkaConfig;
import com.daesoo.rental.domain.event.CatalogChanged;
import com.daesoo.rental.domain.event.PointChanged;
import com.daesoo.rental.domain.event.StockChanged;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.concurrent.ExecutionException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RentalProducerImpl implements RentalProducer {

    /** 토픽명 **/
    private static final String TOPIC_BOOK = "topic_book";

    private static final String TOPIC_CATALOG = "topic_catalog";

    private static final String TOPIC_POINT = "topic_point";

    private final KafkaConfig kafkaConfig;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private KafkaProducer<String, String> producer;

    @PostConstruct
    public void initialize() {
        log.info("Kafka producer initializing...");
        this.producer = new KafkaProducer<>(kafkaConfig.getProducerProps());
        Runtime.getRuntime().addShutdownHook(new Thread(this::shutdown));
        log.info("Kafka producer initialized");
    }

    @Override
    public void updateBookStatus(Long bookId, String bookStatus) throws ExecutionException, InterruptedException, JsonProcessingException {
        StockChanged stockChanged = new StockChanged(bookId, bookStatus);
        String message = objectMapper.writeValueAsString(stockChanged);
        producer.send(new ProducerRecord<>(TOPIC_BOOK, message)).get();
    }

    @Override
    public void savePoints(Long userId, int pointPerBooks) throws JsonProcessingException, ExecutionException, InterruptedException {
        PointChanged pointChanged = new PointChanged(userId, pointPerBooks);
        String message = objectMapper.writeValueAsString(pointChanged);
        producer.send(new ProducerRecord<>(TOPIC_POINT, message)).get();
    }

    @Override
    public void updateBookCatalogStatus(Long bookId, String eventType)
        throws JsonProcessingException, ExecutionException, InterruptedException {
        CatalogChanged catalogChanged = new CatalogChanged();
        catalogChanged.setBookId(bookId);
        catalogChanged.setEventType(eventType);
        String message = objectMapper.writeValueAsString(catalogChanged);
        producer.send(new ProducerRecord<>(TOPIC_CATALOG, message)).get();
    }

    @PreDestroy
    public void shutdown() {
        log.info("Shutdown kafka producer");
        producer.close();
    }
}
