package co.com.sofka.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface CyclistMongoDBRepository extends ReactiveMongoRepository<CyclistDocument, String>, ReactiveQueryByExampleExecutor<CyclistDocument> {
}