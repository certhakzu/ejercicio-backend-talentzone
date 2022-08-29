package co.com.sofka.usecase.country.updatecountry;

import co.com.sofka.model.country.Country;
import co.com.sofka.model.country.gateways.CountryRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateCountryUseCase {
    private final CountryRepository countryRepository;

    public Mono<Country> updateCountry(String id, Country country){
        return countryRepository.update(id, country);
    }
}
