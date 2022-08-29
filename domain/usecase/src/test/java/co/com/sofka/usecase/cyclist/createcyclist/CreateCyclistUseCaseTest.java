package co.com.sofka.usecase.cyclist.createcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.Name;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateCyclistUseCaseTest {
    @InjectMocks
    CreateCyclistUseCase createCyclistUseCase;

    @Mock
    CyclistRepository cyclistRepository;

    @Test
    void createCyclist() {
        var cyclist = new Cyclist("1", new Name("Piter", "Velasquez"), 1, "1", "1");

        var cyclistMono = Mono.just(cyclist);
        when(cyclistRepository.save(cyclist)).thenReturn(cyclistMono);

        StepVerifier.create(createCyclistUseCase.createCyclist(cyclist))
                .expectNextMatches(cyclist1 -> cyclist1.getId().equals("1") && cyclist1.getFullName().equals(new Name("Piter", "Velasquez")) && cyclist1.getCompetitorNumber().equals(1) && cyclist1.getIdTeam().equals("1") && cyclist1.getIdCountry().equals("1"))
                .expectComplete()
                .verify();
    }
}