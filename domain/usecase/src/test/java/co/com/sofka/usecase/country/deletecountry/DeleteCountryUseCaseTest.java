package co.com.sofka.usecase.country.deletecountry;


import co.com.sofka.model.country.Country;
import co.com.sofka.model.country.gateways.CountryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeleteCountryUseCaseTest {
    @InjectMocks
    DeleteCountryUseCase deleteCountryUseCase;

    @Mock
    CountryRepository countryRepository;

    @Test
    void deleteCountry() {
        var country = new Country("1", "colombia", "col");
        /*var countryMono = Mono.just(country);*/

        when(countryRepository.deleteById("1")).thenReturn(Mono.empty());

        /*StepVerifier.create(deleteCountryUseCase.deleteCountry("1"))
                .equals(Mono.empty());*/
        StepVerifier.create(deleteCountryUseCase.deleteCountry("1"))
                .expectNextMatches(unused -> false)
                .expectNext();
    }
}