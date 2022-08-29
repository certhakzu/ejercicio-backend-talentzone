package co.com.sofka.usecase.country.findallcountries;

import co.com.sofka.model.country.Country;
import co.com.sofka.model.country.gateways.CountryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindAllCountriesUseCaseTest {
    @InjectMocks
    FindAllCountriesUseCase findAllCountriesUseCase;

    @Mock
    CountryRepository countryRepository;

    @Test
    void findAllCountries() {
        var country1 = new Country("1", "colombia", "col");
        var country2 = new Country("2", "venezuela", "ven");

        var countriesFlux = Flux.fromIterable(List.of(country1, country2));
        when(countryRepository.findAll()).thenReturn(countriesFlux);

        StepVerifier.create(findAllCountriesUseCase.findAllCountries())
                .expectNextMatches(country -> country.getId().equals("1") && country.getName().equals("colombia") && country.getCode().equals("col"))
                .expectNextMatches(country -> country.getId().equals("2") && country.getName().equals("venezuela") && country.getCode().equals("ven"))
                .expectComplete()
                .verify();
    }
}