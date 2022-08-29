package co.com.sofka.usecase.country.deletecountry;

import co.com.sofka.model.country.gateways.CountryRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteCountryUseCase {
    private final CountryRepository countryRepository;

    public Mono<Void> deleteCountry(String id){
        return countryRepository.deleteById(id);
    }
}
