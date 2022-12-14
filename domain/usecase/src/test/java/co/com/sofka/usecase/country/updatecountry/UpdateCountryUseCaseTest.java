package co.com.sofka.usecase.country.updatecountry;

import co.com.sofka.model.country.Country;
import co.com.sofka.model.country.gateways.CountryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateCountryUseCaseTest {
    @InjectMocks
    UpdateCountryUseCase updateCountryUseCase;

    @Mock
    CountryRepository countryRepository;

    @Test
    void updateCountry() {
        var country = new Country("1", "colombia", "col");

        var countryMono = Mono.just(country);
        when(countryRepository.update("1", country)).thenReturn(countryMono);

        StepVerifier.create(updateCountryUseCase.updateCountry("1", country))
                .expectNextMatches(country1 -> country1.getId().equals("1") && country1.getName().equals("colombia") && country1.getCode().equals("col"))
                .expectComplete()
                .verify();
    }
}