package co.com.sofka.model.country.gateways;

import co.com.sofka.model.country.Country;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CountryRepository {
    Mono<Country> save(Country country);
    Mono<Void> deleteById(String id);
    Mono<Country> update(String id, Country country);
    Mono<Country> findById(String id);
    Flux<Country> findAll();
}
