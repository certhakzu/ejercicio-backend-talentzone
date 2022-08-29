package co.com.sofka.usecase.cyclist.findcyclistsbycountryid;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.Name;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
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
class FindCyclistsByCountryIdUseCaseTest {
    @InjectMocks
    FindCyclistsByCountryIdUseCase findCyclistsByCountryIdUseCase;

    @Mock
    CyclistRepository cyclistRepository;

    @Test
    void findCyclistsByCountryId() {
        var cyclist1 = new Cyclist("1", new Name("Piter", "Velasquez"), 1, "1", "1");
        var cyclist2 = new Cyclist("2", new Name("Alejandro", "Cota"), 2, "2", "1");

        var cyclistsFlux = Flux.fromIterable(List.of(cyclist1, cyclist2));
        when(cyclistRepository.findAll()).thenReturn(cyclistsFlux);

        StepVerifier.create(findCyclistsByCountryIdUseCase.findCyclistsByCountryId("1"))
                .expectNextMatches(cyclist -> cyclist.getId().equals("1") && cyclist.getFullName().equals(new Name("Piter", "Velasquez"))
                        && cyclist.getCompetitorNumber().equals(1) && cyclist.getIdTeam().equals("1")
                        && cyclist.getIdCountry().equals("1"))
                .expectNextMatches(cyclist -> cyclist.getId().equals("2") && cyclist.getFullName().equals(new Name("Alejandro", "Cota"))
                        && cyclist.getCompetitorNumber().equals(2) && cyclist.getIdTeam().equals("2")
                        && cyclist.getIdCountry().equals("1"))
                .expectComplete()
                .verify();
    }
}