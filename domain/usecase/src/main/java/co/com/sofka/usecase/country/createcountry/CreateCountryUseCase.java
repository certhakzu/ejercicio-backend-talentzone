package co.com.sofka.usecase.country.createcountry;

import co.com.sofka.model.country.Country;
import co.com.sofka.model.country.gateways.CountryRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateCountryUseCase {
    private final CountryRepository countryRepository;

    public Mono<Country> createCountry(Country country){
        return countryRepository.save(country);
    }
}
