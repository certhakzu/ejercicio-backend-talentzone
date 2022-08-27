package co.com.sofka.model.cyclist.gateways;

import co.com.sofka.model.cyclist.Cyclist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CyclistRepository {
    Mono<Cyclist> save(Cyclist cyclist);
    Mono<Void> deleteById(String id);
    Mono<Cyclist> update(String id, Cyclist cyclist);
    Mono<Cyclist> findById(String id);
    Flux<Cyclist> findAll();
}
