package co.com.sofka.usecase.country.findallcountry;

import co.com.sofka.model.country.Country;
import co.com.sofka.model.country.gateways.CountryRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class FindAllCountryUseCase {
    private final CountryRepository countryRepository;

    public Flux<Country> findAllCountry(){
        return countryRepository.findAll();
    }
}
