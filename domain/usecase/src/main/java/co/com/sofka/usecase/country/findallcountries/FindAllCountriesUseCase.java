package co.com.sofka.usecase.country.findallcountries;

import co.com.sofka.model.country.Country;
import co.com.sofka.model.country.gateways.CountryRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class FindAllCountriesUseCase {
    private final CountryRepository countryRepository;

    public Flux<Country> findAllCountries(){
        return countryRepository.findAll();
    }
}
