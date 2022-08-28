package co.com.sofka.usecase.country.findcountrybyid;

import co.com.sofka.model.country.Country;
import co.com.sofka.model.country.gateways.CountryRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindCountryByIdUseCase {
    private final CountryRepository countryRepository;

    public Mono<Country> findCountryById(String id){
        return countryRepository.findById(id);
    }
}
